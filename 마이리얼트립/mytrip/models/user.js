const mongoose = require('mongoose');
const bcrypt = require('bcrypt');
const crypto = require('crypto');
const Schema = mongoose.Schema;

var schema = new Schema({
  name: {type: String, required: true, trim: true},
  email: {type: String, required: true, unique: true, trim: true},
  password: {type: String},
  content:{type:String},
  facebook: {id: String, token: String, photo: String},
  naver: {id: String, token: String, photo: String},
  createdAt: {type: Date, default: Date.now},
  level:{type:Number, default:3}

}, {
  toJSON: { virtuals: true},
  toObject: {virtuals: true}
});

schema.methods.generateHash = function(password) {
  return bcrypt.hash(password, 10);
};

schema.methods.validatePassword = function(password) {
  return bcrypt.compare(password, this.password);
};

var User = mongoose.model('User', schema);

module.exports = User;
