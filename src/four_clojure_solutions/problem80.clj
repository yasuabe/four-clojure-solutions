(ns four-clojure-solutions.problem80
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (= n (reduce + (- n)
                (for [m (range 1 (Math/sqrt n))
                      :when (#(= 0 (rem n %)) m)]
                  (+ m (quot n m))))))
 #(= (% 6) true)
 #(= (% 7) false)
 #(= (% 496) true)
 #(= (% 500) false)
 #(= (% 8128) true))
