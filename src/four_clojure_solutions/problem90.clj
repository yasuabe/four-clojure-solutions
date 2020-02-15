(ns four-clojure-solutions.problem90
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [set1 set2]
   (reduce
    (fn [acc1 e1]
      (reduce
       (fn [acc2 e2]
         (conj acc2 [e1 e2]))
       acc1
       set2))
    #{}
    set1))

 #(= (% #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
     #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
       ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
       ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})

 #(= (% #{1 2 3} #{4 5})
     #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

 #(= 300 (count (% (into #{} (range 10))
                   (into #{} (range 30))))))



