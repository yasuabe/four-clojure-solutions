(ns four-clojure-solutions.problem65
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [seq]
   (case (conj (empty seq) [0 0] [0 1])
     {0 1} :map
     #{[0 0] [0 1]} :set
     [[0 0] [0 1]] :vector
     '([0 1] [0 0]) :list))
 
 #(= :map (% {:a 1, :b 2}))
 #(= :list (% (range (rand-int 20))))

 #(= :vector (% [1 2 3 4 5 6]))
 #(= :set (% #{10 (rand-int 5)}))

 #(= [:map :set :vector :list] (map % [{} #{} [] ()])))

