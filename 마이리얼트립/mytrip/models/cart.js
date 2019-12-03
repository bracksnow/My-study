const mongoose = require('mongoose');
const mongoosePaginate = require('mongoose-paginate');
const Schema = mongoose.Schema;

var schema = new Schema({
    author:{ type: Schema.Types.ObjectId, ref: 'User' },
    title: {type: String, trim: true, required: true},
    price:{type:Number, default:0, required:true, min:0},
    numpeople:{type:Number, default:0, required:true},
    totalprice:{type:Number, default:0, required:true}
}, {
  toJSON: { virtuals: true},
  toObject: {virtuals: true}
});
schema.plugin(mongoosePaginate);
var Cart = mongoose.model('Cart', schema);
module.exports = Cart;
