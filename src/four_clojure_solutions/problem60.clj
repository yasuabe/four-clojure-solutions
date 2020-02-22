(ns four-clojure-solutions.problem60
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn my-reductions
   ([f seq]
    (if (empty? seq) (f)
        (let [[h & t] seq]
          (if (empty? t) [h] (my-reductions f h t)))))
   ([f val seq]
    (letfn [(rep [prev seq]
              (if (empty? seq) []
                  (let [next (f prev (first seq))]
                    (lazy-seq (cons next (rep next (rest seq)))))))]
      (cons val (rep val seq)))))

 #(= (take 5 (% + (range))) [0 1 3 6 10])
 #(= (% conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
 #(= (last (% * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))
