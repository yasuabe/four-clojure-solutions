(ns four-clojure-solutions.problem132
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [pred val coll]
   (if (empty? coll) ()
       (let [[h & t] coll]
         (cons h (mapcat #(if (pred % %2) [val %2] [%2]) coll t)))))

 (fn [f] (= '(1 :less 6 :less 7 4 3) (f < :less [1 6 7 4 3])))
 (fn [f] (= '(2) (f > :more [2])))
 (fn [f] (= [0 1 :x 2 :x 3 :x 4]  (f #(and (pos? %) (< % %2)) :x (range 5))))
 (fn [f] (empty? (f > :more ())))
 (fn [f] (= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
            (take 12 (->> [0 1]
                          (iterate (fn [[a b]] [b (+ a b)]))
                          (map first) ; fibonacci numbers
                          (f (fn [a b] ; both even or both odd
                               (= (mod a 2) (mod b 2)))
                             :same))))))
