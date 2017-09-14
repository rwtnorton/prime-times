(ns prime-times.runner
  (:require [prime-times.math :as math]
            [prime-times.tabular :as tabs]
            [clojure.tools.cli :as cli]))

(defn -main
  [& args]
  (let [[opts args banner]
        (cli/cli args
                 ["-h" "--help" "Print this help"
                  :flag true
                  :default false]
                 ["-n" "--count" "Number of primes"
                  :default 10
                  :parse-fn (fn [s] (Long/parseLong s))
                  :validate [(fn [s]
                               (re-seq #"^\d+$" s))
                             "Must be a non-negative whole number"]])]
    (when (:help opts)
      (println banner)
      (System/exit 0))

    (print (tabs/tablify (math/n-primes (:count opts))))))
