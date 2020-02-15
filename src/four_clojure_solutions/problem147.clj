(ns four-clojure-solutions.problem147
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [v]
   (letfn [(next [v] (into [] (map +' (cons 0 v) (conj v 0))))
           (gen [v] (lazy-seq (cons v (gen (next v)))))]
     (gen v)))

 #(= (second (% [2 3 2])) [2 5 5 2])
 #(= (take 5 (% [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
 #(= (take 2 (% [3 1 2])) [[3 1 2] [3 4 3 2]])
 #(= (take 100 (% [2 4 2])) (rest (take 101 (% [2 2])))))


