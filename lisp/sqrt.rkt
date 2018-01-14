#lang racket

(define (sqrt x) 
  (define (try guess x)
    (if (good-enough? guess x)
        guess
        (try (improve guess x) x)
        )
    )
  (define (good-enough? guess x)
    (< (abs (- (square guess) x)) 0.001))

  (define (improve guess x)
    (average guess (/ x guess))
    )
  (define (average x y) (/ (+ x y) 2) )
  (define (square x) (* x x))
  (define (abs x)
    (
     cond ((>= x 0) x)
          ((< x 0) (- x))
          )
    )
  
  (try 1.0 x)
)

(sqrt 9)
(sqrt 2)
  