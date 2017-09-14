(ns prime-times.products-test
  (:require [clojure.test :refer :all]
            [prime-times.products :as p]))

(deftest times-table
  (are [vs expected] (= (p/times-table vs) expected)
    [] []
    [1] [[1]]
    [1 2] [[1 2] [2 4]]
    [1 2 3] [[1 2 3] [2 4 6] [3 6 9]]))
