(ns prime-times.math-test
  (:require [clojure.test :refer :all]
            [prime-times.math :as m]))

(deftest prime?
  (testing "prime numbers"
    (are [n] (m/prime? n)
      2 3 5 7 11 541))
  (testing "composite numbers"
    (are [n] ((complement m/prime?) n)
      1 4 6 8 10 999)))

#_(defn p67 [__]
  [(= (__ 2) [2 3])
   (= (__ 5) [2 3 5 7 11])
   (= (last (__ 100)) 541)])
