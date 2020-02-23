(ns four-clojure-solutions.problem158
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f]
   (fn [& args]
     (loop [f f
            args args]
       (if (empty? args) f
           (let [maybe-func (f (first args))]
             (if (fn? maybe-func)
               (recur maybe-func (rest args))
               maybe-func))))))

 #(= 10 ((% (fn [a]
               (fn [b]
                 (fn [c]
                   (fn [d]
                     (+ a b c d))))))
         1 2 3 4))
 #(= 24 ((% (fn [a]
               (fn [b]
                 (fn [c]
                   (fn [d]
                     (* a b c d))))))
         1 2 3 4))
 #(= 25 ((% (fn [a]
               (fn [b]
                 (* a b))))
         5 5)))




