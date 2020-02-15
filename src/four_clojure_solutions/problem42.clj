(ns four-clojure-solutions.problem39
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [seq1 seq2]
   (loop [s1 seq1
          s2 seq2
          r  ()]
     (if (or (empty? s1) (empty? s2))
       (reverse r)
       (let [[h1 & t1] s1
             [h2 & t2] s2]
         (recur t1 t2 (cons h2 (cons h1 r)))))))

 #(= (% [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
 #(= (% [1 2] [3 4 5 6]) '(1 3 2 4))
 #(= (% [1 2 3 4] [5]) [1 5])
 #(= (% [30 20] [25 15]) [30 25 20 15]))
