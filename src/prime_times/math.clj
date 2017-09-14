(ns prime-times.math)

(defn prime?
  "Returns true iff given number is prime."
  [n]
  (if (integer? n)
    (let [m (->> n Math/sqrt long)
          multiple? (fn [x]
                      (zero? (mod n x)))]
      (if (< n 2)
        false
        (->> (range 2 (inc m))
             (not-any? multiple?))))
    false))

;; Lazy infinite seq of all primes.  Implicitly memoizes.
;; CAVEAT: Important to avoid accidentally realizing the whole lazy seq!
(def primes (filter prime? (range)))

(defn n-primes
  "Returns seq of the first n many primes."
  [n]
  (take n primes))

(defn nth-prime
  "Returns the nth prime (zero-indexed)."
  [n]
  (-> n
      inc
      n-primes
      last))
