(ns day3
  (:require [clojure.java.io :as io]))

(def input (-> "day3.sample.txt"
               (io/resource)
               (slurp)
               (clojure.string/split-lines)))

(slurp "resources/day3.sample.txt")

(count input)

(defn add [a b]
  (+ a b))

(comment
  (+ 1 2)
  (add 4 5)

  (+ 1 2))
