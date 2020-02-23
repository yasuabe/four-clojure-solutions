(ns four-clojure-solutions.problem77
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [words]
   (->> (apply merge-with into (map #(hash-map (sort %) #{%}) words))
        vals
        (filter #(> (count %1) 1))
        set))

 #(= (% ["meat" "mat" "team" "mate" "eat"])
    #{#{"meat" "team" "mate"}})

 #(= (% ["veer" "lake" "item" "kale" "mite" "ever"])
    #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))
