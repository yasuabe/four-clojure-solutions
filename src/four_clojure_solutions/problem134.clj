(ns four-clojure-solutions.problem134
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [k m]
   (and (contains? m k) (nil? (m k))))
 #(true?  (% :a {:a nil :b 2}))
 #(false? (% :b {:a nil :b 2}))
 #(false? (% :c {:a nil :b 2}))
 )

