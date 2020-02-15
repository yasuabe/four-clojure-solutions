(ns four-clojure-solutions.problem171
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [coll]
   (if (empty? coll)
     []
     (let [sorted (sort > coll)]
       (loop [start (first sorted)
              end start
              coll' (coll sorted)
              result ()]
         (if (empty? coll')
           (cons (list start end) result)
           (let [[h & t] coll']
             (if (or (= start h) (= (dec start) h))
               (recur h end t result)
               (recur h h t (cons (list start end) result)))))))))

 #(= (% [1 2 3]) [[1 3]])
 #(= (% [10 9 8 1 2 3]) [[1 3] [8 10]])
 #(= (% [1 1 1 1 1 1 1]) [[1 1]])
 #(= (% []) [])
 #(= (% [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
     [[1 4] [6 6] [9 11] [13 17] [19 19]]))
