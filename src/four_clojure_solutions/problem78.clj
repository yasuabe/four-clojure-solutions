(ns four-clojure-solutions.problem78
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f & args]
   (loop [maybe-fn (apply f args)]
     (if (fn? maybe-fn) (recur (maybe-fn)) maybe-fn)))

 (fn [f] (= (letfn [(triple [x] #(sub-two (* 3 x)))
                    (sub-two [x] #(stop?(- x 2)))
                    (stop? [x] (if (> x 50) x #(triple x)))]
              (f triple 2))
            82))
 (fn [f] (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                    (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
              (map (partial f my-even?) (range 6)))
            [true false true false true false])))
