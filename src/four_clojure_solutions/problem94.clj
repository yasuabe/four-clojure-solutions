(ns four-clojure-solutions.problem94
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [board]
   (let [offsets [[-1 -1] [-1 0] [-1 1]
                  [ 0 -1]        [ 0 1]
                  [ 1 -1] [ 1 0] [ 1 1]]
         height (count board)
         weight (count (nth board 0))
         s-board (apply str board)
         pos #(vector (quot % weight) (mod % weight))
         neighbour-at #(let [[r c] %]
              (if (and (< -1 c weight) (< -1 r height))
                (nth s-board (+ (* r weight) c))))
         neighbours (fn [rc]
              (count
               (filter
                #(= \# %)
                (map #(neighbour-at (map + rc %)) offsets))))
         next-gen (fn [i]
                    (let [state (nth s-board i)
                          n (neighbours (pos i))]
                      (if (= state \#)
                        (if (#{2 3} n) \# \space)
                        (if (= n 3)    \# \space))))]

     (map (fn [r] (apply str r))
          (->> s-board count range (map next-gen) (partition weight)))))

 (fn [f] (= (f ["      "
                " ##   "
                " ##   "
                "   ## "
                "   ## "
                "      "])
            ["      "
             " ##   "
             " #    "
             "    # "
             "   ## "
             "      "]))
 (fn [f] (= (f ["     "
                "     "
                " ### "
                "     "
                "     "])
            ["     "
             "  #  "
             "  #  "
             "  #  "
             "     "]))

 (fn [f] (= (f ["      "
                "      "
                "  ### "
                " ###  "
                "      "
                "      "])
            ["      "
             "   #  "
             " #  # "
             " #  # "
             "  #   "
             "      "])))
