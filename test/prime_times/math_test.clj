(ns prime-times.math-test
  (:require [clojure.test :refer :all]
            [prime-times.math :as m]))

(def not-prime? (complement m/prime?))

(deftest prime?
  (testing "prime numbers"
    (are [n] (m/prime? n)
      2 3 5 7 11 541 29N))
  (testing "composite numbers"
    (are [n] (not-prime? n)
      1 4 6 8 10 999))
  (testing "wacky values are not prime"
    (are [n] (not-prime? n)
      -1 0 nil "" "42" :so-prime false Math/E 99M)))
