(ns four-clojure-solutions.problem19
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (if (next s) (recur (next s)) (first s)))
 #(= (% [1 2 3 4 5]) 5)
 #(= (% '(5 4 3)) 3)
 #(= (% ["b" "c" "d"]) "d")
 )

