(ns four-clojure-solutions.problem153
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (loop [coll (seq s)
          union #{}]
     (if (empty? coll) true
         (let [[h & t] coll]
           (if (not-any? (partial contains? union) h)
             (recur t (clojure.set/union union h))
             false)))))


 #(= (% #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
     true)
 #(= (% #{#{:a :b :c :d :e}
          #{:a :b :c :d}
          #{:a :b :c}
          #{:a :b}
          #{:a}})
     false)

 #(= (% #{#{[1 2 3] [4 5]}
          #{[1 2] [3 4 5]}
          #{[1] [2] 3 4 5}
          #{1 2 [3 4] [5]}})
     true)

 #(= (% #{#{'a 'b}
          #{'c 'd 'e}
          #{'f 'g 'h 'i}
          #{''a ''c ''f}})
     true)

 #(= (% #{#{'(:x :y :z) '(:x :y) '(:z) '()}
          #{#{:x :y :z} #{:x :y} #{:z} #{}}
          #{'[:x :y :z] [:x :y] [:z] [] {}}})
     false)
 #(= (% #{#{(= "true") false}
          #{:yes :no}
          #{(class 1) 0}
          #{(symbol "true") 'false}
          #{(keyword "yes") ::no}
          #{(class '1) (int \0)}})
     false)

 (fn [f] (= (f #{#{(#(-> *)) + (quote mapcat) #_ nil}
                 #{'+ '* mapcat (comment mapcat)}
                 #{(do) set contains? nil?}
                 #{, , , #_, , empty?}})
            false))
 (fn [f] (= (f #{#{distinct?}
                 #{#(-> %) #(-> %)}
                 #{#(-> %) #(-> %) #(-> %)}
                 #{#(-> %) #(-> %) #(-> %)}})
            true)))





