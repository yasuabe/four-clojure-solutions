(ns four-clojure-solutions.problem112
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn f [limit coll]
   (letfn [(f [acc v r]
             (if (empty? v) [acc r true]
                 (let [[h & t] v]
                   (if (number? h)
                     (cond
                       (<= h r) (f (conj acc h) t (- r h))
                       :else [acc r false])
                     (let [[acc2 r2 cont] (f [] h r)]
                       (if cont (f (conj acc acc2) t r2)
                           [(conj acc acc2) r2 cont]))))))]
     (let [[a _ _] (f [] coll limit)] a)))

 (fn [f] (=  (f 10 [1 2 [3 [4 5] 6] 7])
             '(1 2 (3 (4)))))
 (fn [f] (=  (f 10 [[[1] 2] [3 [4 5] 6] 7])
             '(((1) 2) (3 (4)))))
 (fn [f] (=  (f 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
             '(1 2 (3 (4 (5 (6 (7))))))))
 (fn [f] (=  (f 9 (range))
             '(0 1 2 3)))
 (fn [f] (=  (f 1 [[[[[1]]]]])
             '(((((1)))))))
 (fn [f] (=  (f 0 [1 2 [3 [4 5] 6] 7])
             '()))
 (fn [f] (=  (f 0 [0 0 [0 [0]]])
             '(0 0 (0 (0)))))
 (fn [f] (=  (f 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
             '(-10 (1 (2 3 (4)))))))
