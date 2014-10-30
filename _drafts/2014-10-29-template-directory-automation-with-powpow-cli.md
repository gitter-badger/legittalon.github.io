You just setup the perfect directory structure for your new project and now you
want to save it so you can use it again, but you don’t want to deal with all the
fuss of traditional methods. PowPow is here for you.

PowPow is a CLI written in JavaScript that makes managing tarballs dead simple.

To use PowPow you need [Node and NPM so get those][node] and then to install it
globally with npm like so.

```
$ npm install -g powpow
```

PowPow starts off empty so choose your best starting point folder and feed it to
PowPow by using the `add` command.

```
$ powpow add path/to/my/template_folder
```

You can see what templates PowPow knows about by using the `ls` command.

```
$ powpow ls
```

When you’re ready to start a project using your newly PowPow’d template use the
`new` command

```
$ powpow new template_folder my_project
```

This will create a folder in the current directory called `my_project` based on
the `template_folder` template.

If you no longer want powpow to know about a template use the `rm` command.

```
$ powpow rm template_folder
```

[node]: https://gist.github.com/isaacs/579814
