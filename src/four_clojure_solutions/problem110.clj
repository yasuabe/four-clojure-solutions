(ns four-clojure-solutions.problem110
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [ns]
   (let [next (fn [ns]
                (if (empty? ns)
                  []
                  (let [[h & t] ns]
                    (loop [current h
                           ns-rest t
                           count 1
                           acc []]
                      (if (empty? ns-rest)
                        (conj acc count current)
                        (let [[hh & tt] ns-rest]
                          (if (= current hh)
                            (recur hh tt (inc count) acc)
                            (recur hh tt 1 (conj acc count current)))))))))]
     (drop 1 (iterate next ns))))

 #(= [[1 1] [2 1] [1 2 1 1]] (take 3 (% [1])))
 #(= [3 1 2 4] (first (% [1 1 1 4 4])))
 #(= [1 1 1 3 2 1 3 2 1 1] (nth (% [1]) 6))
 #(= 338 (count (nth (% [3 2]) 15))))


