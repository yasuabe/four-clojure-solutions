(ns four-clojure-solutions.problem32
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [numbers]
   (apply concat (map #(list % %) numbers)))

 #(= (% [1 2 3]) '(1 1 2 2 3 3))
 #(= (% [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
 #(= (% [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
 #(= (% [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))

