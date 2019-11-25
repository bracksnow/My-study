const LocalStrategy = require('passport-local').Strategy;
const FacebookStrategy = require('passport-facebook').Strategy;
const User = require('../models/user');

module.exports = function(passport) {
  passport.serializeUser((user, done) => {
    done(null, user.id);
  });

  passport.deserializeUser((id, done) =>  {
    User.findById(id, done);
  });

  passport.use('local-signin', new LocalStrategy({
    usernameField : 'email',
    passwordField : 'password',
    passReqToCallback : true
  }, async (req, email, password, done) => {
    try {
      const user = await User.findOne({email: email});
      if (user && await user.validatePassword(password)) {
        return done(null, user, req.flash('success', 'Welcome!'));
      }
      return done(null, false, req.flash('danger', 'Invalid email or password'));
    } catch(err) {
      done(err);
    }//일반적으로 오래된 콜백형식들은 err이 처음이다
  }));

  passport.use(new FacebookStrategy({
    // 이 부분을 여러분 Facebook App의 정보로 수정해야 합니다.
    clientID : '1192740410927982',
    clientSecret : '180d448ae3f3a762e63adc91a22a440f',
    //클라이언트 아이디와 클라이언트 시크릿은 페이스북 개발자 계정에서 받아서 입력을 해야한다
    callbackURL : 'http://localhost:3000/auth/facebook/callback',//이 줄은 변경할 것 없음 나중에 localhost부분은 바꿔야함
    profileFields : ['email', 'name', 'picture']//이메일, 이름, 사진을 받는 것이고 추가를 해도 되지만 왠만하면 하지 않는 것이 좋음
  }, async (token, refreshToken, profile, done) => {//token, refreshtoken은 공유하기 버튼을 눌렀을 때 사용하는 것
    console.log('Facebook', profile); // profile 정보로 뭐가 넘어오나 보자.
    try {
      var email = (profile.emails && profile.emails[0]) ? profile.emails[0].value : '';
      var picture = (profile.photos && profile.photos[0]) ? profile.photos[0].value : '';
      var name = (profile.displayName) ? profile.displayName : 
        [profile.name.givenName, profile.name.middleName, profile.name.familyName]
          .filter(e => e).join(' ');
      console.log(email, picture, name, profile.name);
      var user = await User.findOne({'facebook.id': profile.id});
      if (!user) {
        if (email) {
          user = await User.findOne({email: email});
        }
        if (!user) {
          user = new User({name: name});
          user.email =  email ? email : `__unknown-${user._id}@no-email.com`;//이것은 임의대로 설정한 것
        }
        user.facebook.id = profile.id;
        user.facebook.photo = picture;
      }
      user.facebook.token = profile.token;
      await user.save();
      return done(null, user);
    } catch (err) {
      done(err);
    }
  }));
};
