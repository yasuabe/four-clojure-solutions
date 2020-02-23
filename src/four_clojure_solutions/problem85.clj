(ns four-clojure-solutions.problem85
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (loop [s (into () s)
          acc #{#{}}]
     (if (empty? s)
       acc
       (let [[h & t] s
             new-acc (clojure.set/union acc (map #(conj % h) acc))]
         (recur t new-acc)))) )

 #(= (% #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})
 #(= (% #{}) #{#{}})
 #(= (% #{1 2 3})
     #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})
 #(= (count (% (into #{} (range 10)))) 1024))
