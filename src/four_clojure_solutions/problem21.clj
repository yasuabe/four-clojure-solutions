(ns four-clojure-solutions.problem21
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn f
   [s n]
   (if (zero? n) (first s) (recur (rest s) (dec n))))
 #(= (% '(4 5 6 7) 2) 6)
 #(= (% [:a :b :c] 0) :a)
 #(= (% [1 2 3 4] 1) 2)
 #(= (% '([1 2] [3 4] [5 6]) 2) [5 6]))

