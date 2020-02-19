(ns four-clojure-solutions.problem107
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [e0]
   #(loop [e e0
          result 1]
     (if (zero? e) result (recur (dec e) (* result %)))))

 #(= 256 ((% 2) 16), ((% 8) 2))
 #(= [1 8 27 64] (map (% 3) [1 2 3 4]))
 #(= [1 2 4 8 16] (map (fn [x] ((% x) 2)) [0 1 2 3 4])))



