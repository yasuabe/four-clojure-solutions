(ns four-clojure-solutions.problem97
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n]
   (nth
    (iterate
     #(let [s (cons 0 %)] (map + s (reverse s)))
     [1])
    (dec n)))

  #(= (map % (range 1 6))
    [[1]
     [1 1]
     [1 2 1]
     [1 3 3 1]
     [1 4 6 4 1]])
  #(= (% 11)
    [1 10 45 120 210 252 210 120 45 10 1])
 )




