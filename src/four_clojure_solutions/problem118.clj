(ns four-clojure-solutions.problem118
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [f coll]
   (letfn [(g [coll]
             (if (empty? coll)
               ()
               (let [[h & t] coll]
                 (lazy-seq (cons (f h) (g t))))))]
    (g coll)))
 
  #(= [3 4 5 6 7]
    (% inc [2 3 4 5 6]))

  #(= (repeat 10 nil)
    (% (fn [_] nil) (range 10)))

  #(= [1000000 1000001]
    (->> (% inc (range))
         (drop (dec 1000000))
         (take 2))))
