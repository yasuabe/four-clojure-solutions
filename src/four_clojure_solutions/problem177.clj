(ns four-clojure-solutions.problem177
  (:require [four-clojure-solutions.checker :refer [checker]]))

(checker
 (fn [s]
   (loop [cs (seq s)
          q ()]
     (or (and (empty? cs) (empty? q))
         (and (not (empty? cs))
              (let [[ch & ct] cs
                    [qh & qt] q]
                (cond
                  (#{\( \[ \{ } ch) (recur ct (cons ch q))
                  (#{[\( \)] [\[ \]] [\{ \}]} [qh ch]) (recur ct qt)
                  (#{\) \] \}} ch) false
                  :else (recur ct q))
                )))))

 (fn [f] (f "This string has no brackets."))
 (fn [f] (f "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }"))
 (fn [f] (not (f "(start, end]")))
 (fn [f] (not (f "())")))
 (fn [f] (not (f "[ { ] } ")))
 (fn [f] (f "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))"))
 (fn [f] (not (f "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))")))
 (fn [f] (not (f "["))))
