(ns aoc2018-1)

;; 파트 1
;; 주어진 입력의 모든 숫자를 더하시오.
;; 예) +10 -2 -5 +1 이 입력일 경우 4를 출력

;(def input (slurp "resources/aoc2018_1.txt"))
;(def str-lines (clojure.string/split-lines input))
;(def numbers (map parse-long str-lines))


(comment
  (reduce + (filter pos? (map parse-long str-lines)))
  (->> str-lines
       (map parse-long)
       (filter (fn [x] (> x 0))) ;; 만약 양수만 필터링하고 싶다면 이 라인 포함
       (reduce +))
  ;; data-last, thread-last ->>
  ;; 함수의 합성을 데이터의 흐름으로 나타낸다!

  (defn sum [numbers]
    (reduce + numbers))
  (sum numbers)

  ;; + 도 함수다!!
  (+ 1 2 3))


;; 파트 2
;; 주어진 입력의 숫자를 더할 때 마다 나오는 숫자 중, 처음으로 두번 나오는 숫자를 리턴하시오.
;; 예) +3, +3, +4, -2, -4 는 10이 처음으로 두번 나오는 숫자임.
;; 0 -> 3 (+3) -> 6 (+3) -> 10(+4) -> 8(-2) -> 4(-4) -> 7(+3) -> 10(+3) -> ...

(comment
  (reduce (fn [[r arr] x]
            [(+ r x) (if (arr r)
                       (reduced r)
                       (do
                         (prn r arr)
                         (conj arr r)))])
          [0 #{}]
          (cycle [3 3 4 -2 -4]))

  (->> [3 3 4 -2 -4]
       cycle
       (reduce (fn [[r arr] x]
                 (prn r arr)
                 (if (arr r)
                   (reduced r)
                   [(+ r x) (conj arr r)]))
               [0 #{}])))
