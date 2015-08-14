# lein-tag-no-sign

A Leiningen plugin to provide a non-signing alternative to vcs tag task.

Leiningen's default `vcs tag` task uses `git tag -s` to create a signed tag. That's cool for many projects, but some others do not need or want to sign their tags. There are a couple of [reported](https://github.com/technomancy/leiningen/issues/1873) [issues](https://github.com/technomancy/leiningen/issues/1799) on leiningen asking about this, but no one took the step to fix it yet.

This plugin is an easy way (ugly hack?) to have this working now, and also a great exercise for me to create a leiningen plugin :)

## Usage

Put `[lein-tag-no-sign "0.1.0"]` into the `:plugins` vector of your project.clj.

The behavior of the tag-no-sign task mimics the `vcs tag` task, except that it doesn't try to sign the tag.

You can call it from the command line

    $ lein tag-no-sign

Or most probably you could use it as part of your customized release-tasks in your project.clj:

```clojure
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version"
                   "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["tag-no-sign"]
                  ["uberjar"]]
```

See the leiningen doc about [Overriding the default :release-tasks](https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md#overriding-the-default-release-tasks) for more info.


## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
