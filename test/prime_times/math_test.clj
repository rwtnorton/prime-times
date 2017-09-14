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

(deftest n-primes
  (are [n expected] (= (m/n-primes n) expected)
    0 []
    1 [2]
    2 [2 3]
    3 [2 3 5]
    10 [2 3 5 7 11 13 17 19 23 29]))

(deftest nth-prime
  (are [n expected] (= (m/nth-prime n) expected)
    0 2
    1 3
    2 5
    3 7
    4 11
    5 13
    6 17
    7 19
    8 23
    9 29))
