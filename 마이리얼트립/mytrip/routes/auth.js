module.exports = (app, passport) => {
    app.get('/signin', (req, res, next) => {
      res.render('signin');
    });
  
    app.post('/signin', passport.authenticate('local-signin', {
      successRedirect : '/tours', // redirect to the secure profile section
      failureRedirect : '/signin', // redirect back to the signup page if there is an error
      failureFlash : true // allow flash messages
    }));
  
    app.get('/auth/facebook',
      passport.authenticate('facebook', { scope : 'email' })
    );
  
    app.get('/auth/facebook/callback',
      passport.authenticate('facebook', {
        failureRedirect : '/signin',
        failureFlash : true // allow flash messages
      }), (req, res, next) => {
        req.flash('success', 'Welcome!');
        res.redirect('/tours');
      }
    );
  
    app.get('/signout', (req, res) => {
      req.logout();//passport를 사용하고 있어서 session을 사용X
      req.flash('success', 'Successfully signed out');
      res.redirect('/');
    });
  };
  