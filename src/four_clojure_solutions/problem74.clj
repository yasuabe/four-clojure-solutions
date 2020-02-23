(ns four-clojure-solutions.problem74
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (let [numbers (map #(Integer/parseInt %) (clojure.string/split s #","))
         square #(* % %)
         square? #(= % (square (int (Math/sqrt %))))]
     (clojure.string/join "," (filter square? numbers))))
 #(= (% "4,5,6,7,8,9") "4,9")
 #(= (% "15,16,25,36,37") "16,25,36"))
