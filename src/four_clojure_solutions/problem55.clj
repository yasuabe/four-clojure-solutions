(ns four-clojure-solutions.problem55
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (into {}
         (for [[k v] (group-by identity coll)] [k (count v)])))

 #(= (% [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
 #(= (% [:b :a :b :a :b]) {:a 2, :b 3})
 #(= (% '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))
