(ns four-clojure-solutions.problem128
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (let [suit (first s)
         rank (second s)
         suit-map {\S :spade \H :heart \D :diamond \C :club}
         rank-map (zipmap (apply list "23456789TJQKA") (range))]
     {:suit (suit-map suit) :rank (rank-map rank)}))

  #(= {:suit :diamond :rank 10} (% "DQ"))
  #(= {:suit :heart :rank 3} (% "H5"))
  #(= {:suit :club :rank 12} (% "CA"))
  #(= (range 13) (map (comp :rank % str)
                    '[S2 S3 S4 S5 S6 S7
                      S8 S9 ST SJ SQ SK SA])))


