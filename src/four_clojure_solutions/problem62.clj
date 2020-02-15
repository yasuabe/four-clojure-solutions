(ns four-clojure-solutions.problem62
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [keys vals]
   (loop [ks keys
          vs vals
          result {}]
     (if (or (empty? ks) (empty? vs))
       result
       (recur (coll ks)
              (coll vs)
              (assoc result (first ks) (first vs))))))

 #(= (% [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
 #(= (% [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
 #(= (% [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))


