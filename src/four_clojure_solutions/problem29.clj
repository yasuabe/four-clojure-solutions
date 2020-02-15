(ns four-clojure-solutions.problem29
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (let [cs (apply list s)]
     (apply str (filter #(Character/isUpperCase %) cs)))) 

 #(= (% "HeLlO, WoRlD!") "HLOWRD")
 #(empty? (% "nothing"))
 #(= (% "$#A(*&987Zf") "AZ"))


