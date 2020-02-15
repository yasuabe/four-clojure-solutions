(ns four-clojure-solutions.problem33
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [seq n]
   (loop [l seq
          result ()]
     (if (empty? l)
       (reverse result)
       (let [[h & t] l] (recur t (concat (repeat n h) result))))))

 #(= (% [1 2 3] 2) '(1 1 2 2 3 3))
 #(= (% [:a :b] 4) '(:a :a :a :a :b :b :b :b))
 #(= (% [4 5 6] 1) '(4 5 6))
 #(= (% [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
 #(= (% [44 33] 2) [44 44 33 33]))


