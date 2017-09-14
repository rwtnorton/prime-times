(ns prime-times.runner
  (:require [prime-times.math :as math]
            [prime-times.tabular :as tabs]))

(defn -main
  [& args]
  (let [n 10]
    (print (tabs/tablify (math/n-primes n)))))
