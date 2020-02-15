(ns four-clojure-solutions.problem122
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (reduce
    #(+ (* %1 2) (if (= \0 %2) 0 1))
    0
    (apply list s)))

 #(= 0     (% "0"))
 #(= 7     (% "111"))
 #(= 8     (% "1000"))
 #(= 9     (% "1001"))
 #(= 255   (% "11111111"))
 #(= 1365  (% "10101010101"))
 #(= 65535 (% "1111111111111111")))
