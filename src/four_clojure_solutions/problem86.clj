(ns four-clojure-solutions.problem86
  (:require [four-clojure-solutions.checker :refer [checker]]
            [clojure.set :refer :all]))

(checker
 (fn [n]
   (letfn [(next-val [n]
             (loop [n n
                    acc 0]
               (let [q (quot n 10)
                     m (mod n 10)
                     acc (+ acc (* m m))]
                 (if (zero? q) acc
                     (recur q acc)))))]
     (loop [n n
            path #{}]
       (cond
         (= 1 n) true
         (contains? path n) false
         :else (recur (next-val n) (conj path n))))))
 #(= (% 7) true)
 #(= (% 986543210) true)
 #(= (% 2) false)
 #(= (% 3) false))
