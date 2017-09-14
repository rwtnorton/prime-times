(defproject prime-times "0.1.0"
  :description "Displays multiplication table of primes to stdout"
  :url "https://github.com/rwtnorton/prime-times"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/math.combinatorics "0.1.4"]
                 [org.clojure/tools.cli "0.3.5"]]
  :main prime-times.runner)
