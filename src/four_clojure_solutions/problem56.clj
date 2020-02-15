(ns four-clojure-solutions.problem56
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (loop [coll coll
          result ()]
     (if (empty? coll) (reverse result)
         (let [[h & t] coll] (recur (remove #{h} t) (cons h result))))))
 #(= (% [1 2 1 3 1 2 4]) [1 2 3 4])
 #(= (% [:a :a :b :b :c :c]) [:a :b :c])
 #(= (% '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
 #(= (% (range 50)) (range 50)))
