(ns four-clojure-solutions.checker)

(defn checker
  [func & cases]
  (every? true? (map #(% func) cases)))
