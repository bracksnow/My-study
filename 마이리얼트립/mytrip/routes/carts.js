const express = require('express');
const Cart = require('../models/cart'); 
const catchErrors = require('../lib/async-error');
const router = express.Router();

function needAuth(req, res, next) {
  if (req.isAuthenticated()) {
    next();
  } else {
    req.flash('danger', 'Please signin first.');
    res.redirect('/signin');
  }
}

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
  const carts = await Cart.paginate(query, {
    sort: {createdAt: -1}, 
    populate: 'author', 
    page: page, limit: limit
  });
  res.render('carts/index', {carts: carts, term: term, query: req.query});
}));

router.get('/:id/edit', needAuth, catchErrors(async (req, res, next) => {
  const cart = await Cart.findById(req.params.id);
  res.render('carts/edit', {cart: cart});
}));

router.put('/:id', catchErrors(async (req, res, next) => {
  const cart = await Cart.findById(req.params.id);
  if (!cart) {
    req.flash('danger', 'Not exist cart');
    return res.redirect('back');
  }
  cart.title = req.body.title;
  cart.numpeople = req.body.numpeople;
  cart.totalprice = req.totalprice;

  await cart.save();
  req.flash('success', 'Successfully updated');
  res.redirect('/carts');
}));

router.delete('/:id', needAuth, catchErrors(async (req, res, next) => {
  await Cart.findOneAndRemove({_id: req.params.id});
  req.flash('success', 'Successfully deleted');
  res.redirect('/carts');
}));

router.post('/', needAuth, catchErrors(async (req, res, next) => {
  const user = req.user;
  var cart = new Cart({
    title: req.body.title,
    author: user._id,
    price: req.body.price,
    numpeople:req.body.numpeople,
    totalprice:req.body.totalprice
  });
  await cart.save();
  req.flash('success', 'Successfully posted');
  res.redirect('/carts');
}));

module.exports = router;