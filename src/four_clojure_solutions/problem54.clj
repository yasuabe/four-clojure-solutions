(ns four-clojure-solutions.problem54
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n coll]
   (loop [coll coll
          result ()]
     (if (< (count coll) n) (reverse result)
         (recur (drop n coll) (cons (take n coll) result)))))

 #(= (% 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
 #(= (% 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
 #(= (% 3 (range 8)) '((0 1 2) (3 4 5))))
