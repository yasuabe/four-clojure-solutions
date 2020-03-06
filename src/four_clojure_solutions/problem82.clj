(ns four-clojure-solutions.problem82
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [words]
   (letfn [(count-by [pred coll]
             (reduce (fn [acc e] (if (pred e) (inc acc) acc)) 0 coll))
           (cat [l m r] (str (apply str l) m (apply str r)))
           (count-edges [s t]
             (let [len (count s)
                   ins (map #(let [[l r] (split-at % s)] (cat l "." r))
                            (range 0 (inc len)))
                   rep (map #(let [[l [_ & rt]] (split-at % s)] (cat l ".?" rt))
                            (range 0 len))]
               (some #(re-matches (re-pattern %) t) (concat ins rep))))]

     (let [edge-counts
           (map (fn [w] (count-by #(count-edges w %) words))words)]
       (<= (count-by #(<= % 2) edge-counts) 2))))

 (fn [f] (= true (f #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
 (fn [f] (= false (f #{"cot" "hot" "bat" "fat"})))
 (fn [f] (= false (f #{"to" "top" "stop" "tops" "toss"})))
 (fn [f] (= true (f #{"spout" "do" "pot" "pout" "spot" "dot"})))
 (fn [f] (= true (f #{"share" "hares" "shares" "hare" "are"})))
 (fn [f] (= false (f #{"share" "hares" "hare" "are"}))))
