(ns four-clojure-solutions.problem34
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [start end]
   (take-while #(< % end) (iterate inc start)))

 #(= (% 1 4) '(1 2 3))
 #(= (% -2 2) '(-2 -1 0 1))
 #(= (% 5 8) '(5 6 7)))

