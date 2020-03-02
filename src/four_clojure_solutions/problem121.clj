(ns four-clojure-solutions.problem121
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [node]
   (fn [variable-map]
     (letfn [(f [node]
               (cond
                 (number? node) node
                 (symbol? node) (variable-map node)
                 (list? node) (let [[h & t] node
                                    op (condp = h
                                         '/ /
                                         '+ +
                                         '- -
                                         '* *)]
                                (apply op (map f t)))))]
       (f node))))
 (fn [f] (= 2 ((f '(/ a b))
               '{b 8 a 16})))

 (fn [f] (= 8 ((f '(+ a b 2))
               '{a 2 b 4})))

 (fn [f] (= [6 0 -4]
            (map (f '(* (+ 2 a) (- 10 b)))
                 '[{a 1 b 8} {b 5 a -2} {a 2 b 11}])))
 (fn [f] (= 1 ((f '(/ (+ x 2)
                      (* 3 (+ y 1))))
               '{x 4 y 1}))))
