(ns four-clojure-solutions.problem38
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [& numbers]
   (loop [ns (coll numbers)
          result (first numbers)]
     (if (empty? ns)
       result
       (let [[h & t] ns] (recur t (if (< h result) result h))))))

 #(= (% 1 8 3 4) 8)
 #(= (% 30 20) 30)
 #(= (% 45 67 11) 67))
