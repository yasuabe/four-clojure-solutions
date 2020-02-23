(ns four-clojure-solutions.problem102
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [in-str]
   (let [trimmed (clojure.string/replace in-str #"-*$" "")]
     (if (empty? trimmed) ""
         (let [[ch & ct :as cs] (apply list (reverse trimmed))
               upper-ch #(first (clojure.string/upper-case %))
               func (fn [ch coll]
                      (if (= \- ch)
                        (cons (upper-ch (first coll)) (rest coll))
                        (cons ch coll)))]
           (loop [cs cs
                  rev []]
             (if (empty? cs) (apply str rev)
                 (recur (rest cs) (func (first cs) rev))))))))

 #(= (% "something") "something")
 #(= (% "multi-word-key") "multiWordKey")
 #(= (% "leaveMeAlone") "leaveMeAlone"))




