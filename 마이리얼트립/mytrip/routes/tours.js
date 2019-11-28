const express = require('express');
const Tour = require('../models/tour');
const Answer = require('../models/answer'); 
const catchErrors = require('../lib/async-error');
const router = express.Router();

// 동일한 코드가 users.js에도 있습니다. 이것은 나중에 수정합시다.
function needAuth(req, res, next) {
  if (req.isAuthenticated()) {
    next();
  } else {
    req.flash('danger', 'Please signin first.');
    res.redirect('/signin');
  }
}

/* GET questions listing. */
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

router.put('/:id', catchErrors(async (req, res, next) => {
  const tour = await Tour.findById(req.params.id);

  if (!tour) {
    req.flash('danger', 'Not exist tour');
    return res.redirect('back');
  }
  tour.title = req.body.title;
  tour.content = req.body.content;

  await tour.save();
  req.flash('success', 'Successfully updated');
  res.redirect('/tours');
}));

router.delete('/:id', needAuth, catchErrors(async (req, res, next) => {
  await Tour.findOneAndRemove({_id: req.params.id});
  req.flash('success', 'Successfully deleted');
  res.redirect('/tours');
}));

router.post('/', needAuth, catchErrors(async (req, res, next) => {
  const user = req.user;
  var tour = new Tour({
    title: req.body.title,
    author: user._id,
    content: req.body.content,
    price: req.body.price,
    day: req.body.day,
    city:req.body.city,
    country:req.body.country,
    number_of_pepple:req.body.number_of_people
  });
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

  req.flash('success', 'Successfully answered');
  res.redirect(`/tours/${req.params.id}`);
}));



module.exports = router;
