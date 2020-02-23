(ns four-clojure-solutions.problem70
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (->> (clojure.string/split s #"[ .!?\\-]")
        (map #(list (.toUpperCase %) %))
        (sort-by first)
        (map second)))

 #(= (%  "Have a nice day.")
     ["a" "day" "Have" "nice"])

 #(= (%  "Clojure is a fun language!")
     ["a" "Clojure" "fun" "is" "language"])

 #(= (%  "Fools fall for foolish follies.")
     ["fall" "follies" "foolish" "Fools" "for"]))




