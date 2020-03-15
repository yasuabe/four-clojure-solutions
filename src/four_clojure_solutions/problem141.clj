(ns four-clojure-solutions.problem141
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [trump]
   (fn [cards]
     (let [trump (or trump (-> cards first :suit))
           comp-card #(let [{s1 :suit, r1 :rank} %1
                            {s2 :suit, r2 :rank} %2
                            trump? (partial = trump)
                            suit-order (compare (trump? s2) (trump? s1))]
                        (if (zero? suit-order) (compare r2 r1) suit-order))]
       (->> cards (sort comp-card) first))))

 (fn [f] (let [notrump (f nil)]
           (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                                    {:suit :club :rank 9}]))
                (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                    {:suit :club :rank 10}])))))

 (fn [f] (= {:suit :club :rank 10} ((f :club) [{:suit :spade :rank 2}
                                               {:suit :club :rank 10}])))

 (fn [f] (= {:suit :heart :rank 8}
            ((f :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                         {:suit :diamond :rank 10} {:suit :heart :rank 4}]))))

