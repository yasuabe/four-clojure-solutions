(ns four-clojure-solutions.problem24
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [ns] (reduce + ns))
 #(= (% [1 2 3]) 6)
 #(= (% (list 0 -2 5 5)) 8)
 #(= (% #{4 2 1}) 7)
 #(= (% '(0 0 -1)) -1)
 #(= (% '(1 10 3)) 14))

