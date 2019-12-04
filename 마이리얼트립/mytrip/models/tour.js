const mongoose = require('mongoose');
const mongoosePaginate = require('mongoose-paginate');
const Schema = mongoose.Schema;

var schema = new Schema({
  author: { type: Schema.Types.ObjectId, ref: 'User' },
  title: {type: String, trim: true, required: true},
  content: {type: String, trim: true, required: true},
  price:{type:Number, default:0, required:true, min:0},
  date:{type:Date, required:true},
  day:{type:Number, default:0, required:true,min:0},
  country:{type:String, required:true},
  city:{type:String, required:true},
  number_of_people:{type:Number,default:0, required:true},
  createdAt: {type: Date, default: Date.now},
  numLikes: {type: Number, default: 0},
  numAnswers: {type: Number, default: 0},
  numReads: {type: Number, default: 0},
  course:{type:String, trim:true}
}, {
  toJSON: { virtuals: true},
  toObject: {virtuals: true}
});
schema.plugin(mongoosePaginate);
var Tour = mongoose.model('Tour', schema);

module.exports = Tour;
