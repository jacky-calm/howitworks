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

(define (identidy x) x)
(define (square x) (* x x))
(define (1+ x) (+ x 1))


(define (sum term from next to)
  (if (> from to)
      0
      (+ (term from)
         (sum term (next from) next to) ) )
  )

(sum-int 1 3)
(sum-int-square 1 3)

(sum identidy 1 1+ 3 )
(sum square 1 1+ 3 )