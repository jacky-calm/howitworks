#lang racket
(define (sum-int from to)
  (if (> from to)
      0
      (+ (sum-int from (- to 1)) to) )
  )

(define (sum-int-square from to)
  (if (> from to)
      0
      (+ (sum-int-square from (- to 1)) (square to)) )
  )

(define (itself x) x)
(define (square x) (* x x))


(define (sum-func from to func)
  (if (> from to)
      0
      (+ (sum-func from (- to 1) func) (func to)) )
  )

(sum-int 1 3)
(sum-int-square 1 3)

(sum-func 1 3 itself)
(sum-func 1 3 square)