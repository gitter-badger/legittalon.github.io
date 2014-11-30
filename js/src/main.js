var $           = require('jquery');
var $ghost      = $('#omni-ghost');
var thresh      = require('thresh')({
  threshold: {
    up: 200,
    down: 50,
    top: 100,
    bottom: 100
  }
});

thresh.on('up', function() {
  $ghost.removeClass('animated fadeOutDown');
  $ghost.addClass('animated fadeInUp');
});
thresh.on('bottom', function() {
  $ghost.removeClass('animated fadeOutDown');
  $ghost.addClass('animated fadeInUp');
});
thresh.on('top', function() {
  $ghost.removeClass('animated fadeOutDown');
  $ghost.addClass('animated fadeInUp');
});

thresh.on('down', function() {
  $ghost.removeClass('animated fadeInUp');
  $ghost.addClass('animated fadeOutDown');
});
