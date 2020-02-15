(ns four-clojure-solutions.problem22
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (loop [s (apply list s)
          result []]
     (if (empty? s)
       result
       (let [[h & t] s] (recur t (cons h result))))))
 #(= (% [1 2 3 4 5]) [5 4 3 2 1])
 #(= (% (sorted-set 5 7 2 7)) '(7 5 2))
 #(= (% [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))
