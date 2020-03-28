(ns four-clojure-solutions.problem124
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [board target]
   (letfn [(on-board? [[c r]]
             (and (<= 0 c) (<= 0 r) (< r 4) (< c 4)))
           (at [pos]
             (if-let [[c r] pos]
               (-> board (nth c) (nth r))))
           (flip [pos dir]
             (let [candidates
                   (next (take-while on-board?
                                     (iterate #(mapv + % dir) pos)))
                   [seq1 [h & _]] (split-with
                                   #('#{[w b] [b w]} [(at %) target])
                                   candidates)]
               (if (= target (at h)) (set seq1) nil)))
           (place [pos]
             (filter (comp not-empty second)
                     (for [c-offset [-1 0 1]
                           r-offset [-1 0 1]
                           :when (not= [0 0] [r-offset c-offset])]
                       [pos (flip pos [r-offset c-offset])])))]
     (into {}
           (apply concat
                  (for [r (range 4)
                        c (range 4)
                        :when (= 'e (at [r c]))]
                    (place [r c]))))))

 (fn [f] (= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
            (f '[[e e e e]
                 [e w b e]
                 [e b w e]
                 [e e e e]] 'w)))
 (fn [f] (= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
            (f '[[e e e e]
                 [e w b e]
                 [w w w e]
                 [e e e e]] 'b)))
 (fn [f] (= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
            (f '[[e e e e]
                 [e w b e]
                 [w w b e]
                 [e e b e]] 'w)))
 (fn [f] (= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
            (f '[[e e w e]
                 [b b w e]
                 [b w w e]
                 [b w w w]] 'b))))
