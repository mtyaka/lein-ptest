# lein-ptest

Experimental [leiningen](https://github.com/technomancy/leiningen)
plugin for running tests in parallel. It runs tests for each namespace
in a separate thread.

## Usage

Add it as a development dependency in your `project.clj`

    :dev-dependencies [[lein-ptest 0.0.1-SNAPSHOT]]

or install as a user-level leiningen plugin.

    lein plugin install lein-ptest 0.0.1-SNAPSHOT

Run the tests in parallel with:

    lein ptest

You can tag a namespace whose tests shouldn't run in parallel by
setting `:non-parallel` to `true` in the namespace metadata.

## License

Copyright © 2011 Matjaz Gregoric

Distributed under the Eclipse Public License, the same as Clojure.
