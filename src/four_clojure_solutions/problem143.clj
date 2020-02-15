(ns four-clojure-solutions.problem143
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [v1 v2]
   (reduce + (map * v1 v2)))

 #(= 0 (% [0 1 0] [1 0 0]))
 #(= 3 (% [1 1 1] [1 1 1]))
 #(= 32 (% [1 2 3] [4 5 6]))
 #(= 256 (% [2 5 6] [100 10 1])))




