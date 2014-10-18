---
published: false
---

## For the learning of it!

Today we will learn how to build our own event system in javascript to enable such coding styles as:

{% highlight javascript %}
event.on('event', function(stuff) {
  // do things with stuff
})
{% endhighlight %}

## What are events?

Events are just a string that identifies a name for the event and an array of functions executed when we emit that event name.

We need three things to get us up and running
- an object mapping keys to an array of functions
- .on method that attaches functions to event namespaces
- .emit method that tells a namespace to run all of its functions

## Let's begin.

We will start by defining our namespace as an object.

{% highlight javascript %}
var events = {}
{% endhighlight %}

We will add properties and methods onto this object and it can be used modularly by cloning it via the javascript `Object.prototype.create`

## events.events

This is initialized as just an empty object. Internally it will follow the structure of `{'event name': []}` where the array contains functions.

{% highlight javascript %}
event.event = {}
{% endhighlight %}

## events.on

The on method takes a string and a function and pushes the function to the appropriate namespace on the `events.events` object! `this` referes to the `events` object.

{% highlight javascript %}
events.on = function(namespace, fn) {
  /**
   * If this is the first function provided to the namespace then
   * the namespace will not be an array so we must first initialize it as an    
   * array. Then we push the function to the array.
   */
  if (!(this.events[namespace] instanceof Array)) {
    this.events = []
  }
  this.events[namespace].push(fn)
}
{% endhighlight %}

## events.emit

Emitting an event should run all the functions attached to it and pass each function some arguments, if desired. We do a few tricky things in this function. 

First we use the `arguments` object available inside all javascript functions. This is a pseudo-array of all the arguments with which the function was called. Psuedo-arrays are stupid javascript things that look like arrays but aren't descendant from the `Array.prototype`. Fortunately we can force psuedo-arrays to be real arrays by using a little `Function.prototype` trickery:

{% highlight javascript %}
/**
 * This uses the `Function.prototype.call` method to pass the arguments
 * psuedo-array to the `Array.prototype.slice` function. This returns the     
 * psuedo-array as a descendant of the array letting us use `Array.prototype`
 * methods on it!
 */
var args = Array.prototype.slice.call(arguments)
{% endhighlight %}

Secondly we use the `Array.prototype.unshift` method which removes the first element from the array and returns it. We don't care about the first element so we do not capture the return value in a variable.

Lastly we use the `Function.prototype.apply` method which takes a context to pass to the function as its `this` value and an array of arguments to also pass to the function.

Here's the full method.

{% highlight javascript %}
events.emit = function(namespace) {
  /**
   * First check to see if the event has any functions associated with it.
   * events that aren't arrays don't so return without doing anything.
   *
   * Otherwise call the event and pass in any arguments we want the event to  
   * recieve.
   */
  if (!(this.events[namespace] instanceof Array) {
    return
  }
  this.events[namespace].forEach(function(fn) {
    var args = Array.prototype.slice.call(arguments)
    args.shift()
    fn.apply(null, args)
  })
}
{% endhighlight %}

## That's it

Now you can subscribe to and emit events inside your application. Don't just stop here though. I challenge you to modify this object to have a `.off` method that takes some identifier and removes a function from an event. Good luck!