(ns four-clojure-solutions.problem79
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn x [vv]
   (letfn [(select-min [x y] (if (< (first x) (first y)) x y))
           (select-mins [v]
             (map select-min v (rest v)))
           (merge-path [v w]
             (map (fn ([x y] [(+ x (first y)) (cons x (rest y))])) v w))]
     (let [[last-row & other-rows] (reverse vv)]
       (loop [rows other-rows
              acc (map #(vector % (list %)) last-row)]
         (if (empty? rows) (first (first acc))
             (let [[h & t] rows]
               (recur t (merge-path h (select-mins acc)))))))))

 #(= 7 (% '([1]
             [2 4]
             [5 1 4]
             [2 3 4 5]))) ; 1->2->1->3
 #(= 20 (% '([3]
              [2 4]
              [1 9 3]
              [9 9 2 4]
              [4 6 6 7 8]
              [5 7 3 5 1 4])))) ; 3->4->3->2->7->1
