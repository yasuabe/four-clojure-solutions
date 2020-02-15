(ns four-clojure-solutions.problem31
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s0]
   (loop [s' (coll s0)
          prev (first s0)
          result (list (list prev))]
     (if (empty? s')
       (reverse result)
       (let [[sh & st] s'
             [rh & rt] result]
         (if (= prev sh) (recur st sh (cons (cons sh rh) rt))
             (recur st sh (cons (list sh) result)))))))

 #(= (% [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
 #(= (% [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
 #(= (% [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))

