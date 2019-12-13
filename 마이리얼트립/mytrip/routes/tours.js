const express = require('express');
const Tour = require('../models/tour');
const User = require('../models/user'); 
const Answer = require('../models/answer'); 
const catchErrors = require('../lib/async-error');
const multer = require('multer');
const fs = require('fs-extra');
const path = require('path');

module.exports = io => {
  const router = express.Router();
  
  function needAuth(req, res, next) {
    if (req.isAuthenticated()) {
      next();
    } else {
      req.flash('danger', 'Please signin first.');
      res.redirect('/signin');
    }
  }
  function validateForm(form, options) {
    var title = form.title || "";
    title = title.trim();
  
    if (!title) {
      return '제목을 입력하시오';
    }
  
    if (!form.content) {
      return '여행 상세내용을 입력하시오';
    }
  
    if (!form.price) {
      return '상품 가격을 입력하시오';
    }
  
    if (!form.day) {
      return '상품 가격을 입력하시오';
    }
  
    if (!form.country) {
      return '여행 국가를 입력하시오';
    }
    if (!form.city) {
      return '대표적으로 여행하는 도시를 입력하시오';
    }
  
    return null;
  }

  /* GET tours listing. */
  router.get('/', catchErrors(async (req, res, next) => {
    const page = parseInt(req.query.page) || 1;
    const limit = parseInt(req.query.limit) || 10;

    var query = {};
    const term = req.query.term;
    if (term) {
      query = {$or: [
        {title: {'$regex': term, '$options': 'i'}},
        {content: {'$regex': term, '$options': 'i'}}
      ]};
    }
    const tours = await Tour.paginate(query, {
      sort: {createdAt: -1}, 
      populate: 'author', 
      page: page, limit: limit
    });
    res.render('tours/index', {tours: tours, term: term, query: req.query});
  }));

  router.get('/new', needAuth, (req, res, next) => {
    res.render('tours/new', {tour: {}});
  });

  router.get('/:id/edit', needAuth, catchErrors(async (req, res, next) => {
    const tour = await Tour.findById(req.params.id);
    res.render('tours/edit', {tour: tour});
  }));

  router.get('/:id', catchErrors(async (req, res, next) => {
    const tour = await Tour.findById(req.params.id).populate('author');
    const answers = await Answer.find({tour: tour.id}).populate('author');
    tour.numReads++; 
    await tour.save();
    res.render('tours/show', {tour: tour, answers: answers});
  }));

  router.post('/:id', catchErrors(async (req, res, next) => {
    const tour = await Tour.findById(req.params.id);
    const err = validateForm(req.body);
    if (err) {
      req.flash('danger', err);
      return res.redirect('back');
    }
  

    if (!tour) {
      req.flash('danger', 'Not exist tour');
      return res.redirect('back');
    }
    tour.title = req.body.title;
    tour.content = req.body.content;
    tour.date= req.body.date;
    tour.price=req.body.price;
    tour.day=req.body.day;
    tour.city= req.body.city;
    tour.country=req.body.country;
    tour.course=req.body.course;
    await tour.save();
    req.flash('success', 'Successfully updated');
    res.redirect('/tours');
  }));

  router.delete('/:id', needAuth, catchErrors(async (req, res, next) => {
    await Tour.findOneAndRemove({_id: req.params.id});
    req.flash('success', 'Successfully deleted');
    res.redirect('/tours');
  }));


  const mimetypes = {
    "image/jpeg": "jpg",
    "image/gif": "gif",
    "image/png": "png"
  };
  const upload = multer({
    dest: 'tmp', 
    fileFilter: (req, file, cb) => {
      var ext = mimetypes[file.mimetype];
      if (!ext) {
        return cb(new Error('Only image files are allowed!'), false);
      }
      cb(null, true);
    }
  }); // tmp라는 폴더를 미리 만들고 해야 함.

  router.post('/', needAuth, 
        upload.single('img'), // img라는 필드를 req.file로 저장함.
        catchErrors(async (req, res, next) => {
    var tour = new Tour({
      title: req.body.title,
      author: req.user._id,
      content: req.body.content,
      date: req.body.date,
      price: req.body.price,
      day: req.body.day,
      city:req.body.city,
      country:req.body.country,
      course:req.body.course
    });
    const err = validateForm(req.body);
    if (err) {
      req.flash('danger', err);
      return res.redirect('back');
    }
  
    if (req.file) {
      const dest = path.join(__dirname, '../public/images/uploads/');  // 옮길 디렉토리
      console.log("File ->", req.file); // multer의 output이 어떤 형태인지 보자.
      const filename = tour.id + "/" + req.file.originalname;
      await fs.move(req.file.path, dest + filename);
      tour.img = "/images/uploads/" + filename;
    }
    await tour.save();
    req.flash('success', 'Successfully posted');
    res.redirect('/tours');
  }));

  router.post('/:id/answers', needAuth, catchErrors(async (req, res, next) => {
    const user = req.user;
    const tour = await Tour.findById(req.params.id);

    if (!tour) {
      req.flash('danger', 'Not exist tour');
      return res.redirect('back');
    }

    var answer = new Answer({
      author: user._id,
      tour: tour._id,
      content: req.body.content
    });
    await answer.save();
    tour.numAnswers++;
    await tour.save();

    const url = `/tours/${tour._id}#${answer._id}`;
    io.to(tour.author.toString())
      .emit('answered', {url: url, tour: tour});
    console.log('SOCKET EMIT', tour.author.toString(), 'answered', {url: url, tour: tour})
    req.flash('success', 'Successfully answered');
    res.redirect(`/tours/${req.params.id}`);
  }));

  return router;
};
