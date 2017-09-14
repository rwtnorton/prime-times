(ns prime-times.runner
  (:require [prime-times.math :as math]
            [prime-times.tabular :as tabs]
            [clojure.tools.cli :as cli]
            [clojure.string :as str]))

(def cli-options
  [["-h" "--help" "Print this help"
    :default false]
   ["-n" "--count N" "Number of primes"
    :default 10
    :parse-fn (fn [s] (Long/parseLong s))
    :validate [(fn [s]
                 (re-seq #"^\d+$" (str s)))
               "Must be a non-negative whole number"]]])

(defn usage
  [opts]
  (str/join "\n"
            ["Usage: prime-times [options]"
             ""
             "Options:"
             opts]))

(defn -main
  [& args]
  (let [{:keys [options
                arguments
                errors
                summary]} (cli/parse-opts args cli-options)]
    (when errors
      (binding [*out* *err*]
        (println "Errors:")
        (println (str/join "\n" errors) "\n")
        (println (usage summary)))
      (System/exit 1))

    (when (:help options)
      (println (usage summary))
      (System/exit 0))

    (print (tabs/tablify (math/n-primes (:count options))))))
