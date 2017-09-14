# prime-times

A Clojure library to generate a multiplication table of N (default 10) primes,
written to stdout.

## Usage

```
  $ lein run
  ## or via bash script:
  $ ./bin/prime-times
  
  ### display supported options
  $ lein run -- --help
  $ ./bin/prime-times --help
  
  ### run with a different number of primes (default is 10)
  $ lein run -- --count 13
  $ ./bin/prime-times --count 13
```

## Tests

Run tests via:
```
  $ lein test
```

## License

The MIT License (MIT) Copyright © 2017 Richard Norton
