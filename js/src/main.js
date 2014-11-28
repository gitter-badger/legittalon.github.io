var SmartReveal = require('smart-reveal');

var ghost = new SmartReveal('#omni-ghost', {
  transitionIn: function($el) {
    $el.removeClass('animated fadeOutDown');
    $el.addClass('animated fadeInUp');
  },

  transitionOut: function($el) {
    $el.removeClass('animated fadeInUp');
    $el.addClass('animated fadeOutDown');
  },
});

ghost.smartReveal();
