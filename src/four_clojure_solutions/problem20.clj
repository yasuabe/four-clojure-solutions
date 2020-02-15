(ns four-clojure-solutions.problem19
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (let [[eh & et] coll]
     (if (next et) (recur et) eh)))
 #(= (% (list 1 2 3 4 5)) 4)
 #(= (% ["a" "b" "c"]) "b")
 #(= (% [[1 2] [3 4]]) [1 2]))

