(ns four-clojure-solutions.problem49
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n coll]
   (loop [m n
          rear coll
          front ()]
     (if (= 0 m)
       [(reverse front) rear]
       (recur (dec m)
              (coll rear)
              (cons (first rear) front)))))

 #(= (% 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
 #(= (% 1 [:a :b :c :d]) [[:a] [:b :c :d]])
 #(= (% 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))

