# fuzzy-string

[![travis-ci status](https://travis-ci.org/mihi-tr/fuzzy-string.svg)](https://travis-ci.org/mihi-tr/fuzzy-string)

A Clojure library for fuzzy string matching

It implements the following matching algorithms

* dice
* levenshtein
* nilsimsa hashes (fuzzy-string.nilsimsa)

## Usage

add the following to your lein project:

[![Clojars
Project](http://clojars.org/fuzzy-string/latest-version.svg)](http://clojars.org/fuzzy-string)

then 
```clojure
  (use 'fuzzy-string.core)
  (dice "Hair" "Wear")
  (levenshtein "Hair" "Wear")
```


## License

Copyright © 2013-2015 Michael Bauer

Distributed under the Eclipse Public License, the same as Clojure.
