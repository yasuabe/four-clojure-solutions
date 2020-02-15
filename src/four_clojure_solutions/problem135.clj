(ns four-clojure-solutions.problem135
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [ah & at]
   (loop [coll at
          acc ah]
     (if (empty? coll) acc 
         (let [[h1 h2 & t] coll]
           (recur t (h1 acc h2))))))

 #(= 7  (% 2 + 5))
 #(= 42 (% 38 + 48 - 2 / 2))
 #(= 8  (% 10 / 2 - 1 * 2))
 #(= 72 (% 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))


