(ns four-clojure-solutions.problem88
  (:require [four-clojure-solutions.checker :refer [checker]]
            [clojure.set :refer :all]))

(checker
 (fn [s1 s2]
   (difference (union s1 s2) (intersection s1 s2)))
 #(= (% #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
 #(= (% #{:a :b :c} #{}) #{:a :b :c})
 #(= (% #{} #{4 5 6}) #{4 5 6})
 #(= (% #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))




