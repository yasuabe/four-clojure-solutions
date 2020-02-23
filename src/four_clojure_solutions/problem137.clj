(ns four-clojure-solutions.problem137
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [n base]
   (loop [n n
          acc []]
     (if (zero? n)
       (if (empty? acc) [0] acc)
       (recur (quot n base) (cons (mod n base) acc)))))

 #(= [1 2 3 4 5 0 1] (% 1234501 10))
 #(= [0] (% 0 11))
 #(= [1 0 0 1] (% 9 2))
 #(= [1 0] (let [n (rand-int 100000)](% n n)))
 #(= [16 18 5 24 15 1] (% Integer/MAX_VALUE 42)))

