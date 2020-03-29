(ns four-clojure-solutions.problem138
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [start limit]
   (let [
         square #(* % %)
         [wid chs]
         (let [sqr-str (->> (iterate square start)
                            (take-while #(<= % limit))
                            (map str)
                            (apply concat))
               [wd sq] (->> (range)
                            (map #(vector % (square %)))
                            (drop-while #(< (second %) (count sqr-str)))
                            first)]
           [wd (->> (repeat \*)
                    (concat sqr-str)
                    (take sq))])
         positions-at (fn [level]
                        (let [sgn (if (even? level) 1 -1)
                              half (range level)
                              rows (concat half `(~level) (reverse half))
                              cols (range (- level) (inc level))]
                          (map vector
                               (if (pos? sgn) (map - rows) (map inc rows))
                               (map #(* sgn %) cols))))
         all-positions (->> (range wid)
                            (map positions-at)
                            (apply concat)
                            (map #(map (fn [m] (+ wid m -1)) %))
                            (map (fn [[r c :as pos]]
                                   (if (even? wid) [(dec r) c] pos))))
         pos-ch-map (into {} (map vector all-positions chs))
         wid2 (+ wid wid -1)]
     (->> (for [r (range wid2) c (range wid2)]
            (get pos-ch-map [r c] \space))
          (apply str)
          (partition wid2)
          (map #(apply str %)))))

 (fn [f] (= (f 10 10000) ["   0   "
                          "  1 0  "
                          " 0 1 0 "
                          "* 0 0 0"
                          " * 1 * "
                          "  * *  "
                          "   *   "]))
 (fn [f] (= (f 2 256) ["  6  "
                       " 5 * "
                       "2 2 *"
                       " 6 4 "
                       "  1  "]))
 (fn [f] (= (f 2 256) ["  6  "
                       " 5 * "
                       "2 2 *"
                       " 6 4 "
                       "  1  "]))
 (fn [f] (= (f 3 81) [" 3 "
                      "1 9"
                      " 8 "]))
 (fn [f] (= (f 2 4) [" 2 "
                     "* 4"
                     " * "]))
 (fn [f] (= (f 2 2) ["2"])))
