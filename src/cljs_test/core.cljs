(ns cljs-test.core 
  (:require [typed.internal :refer [print-env]])
  (:require-macros [typed.core :as t]))

(t/cljs-ann occurrence-t [(U nil [-> BooleanCLJS]) -> BooleanCLJS])
(defn occurrence-t [x]
  (if x
    (do 
      (print-env "then branch")
      (x))
    (do 
      (print-env "else branch")
      false)))

;ambrose@ambrose-VirtualBox:~/Projects/cljs-test$ lein trampoline cljsbuild repl-rhino
;Running Rhino-based ClojureScript REPL.
;"Type: " :cljs/quit " to quit"
;ClojureScript:cljs.user> (ns cljs-test.core)
;
;ClojureScript:cljs-test.core> (load-file "cljs_test/core.cljs")
;
;ClojureScript:cljs-test.core> (t/check-cljs-ns)
;"then branch"{:env {x (Fn [-> BooleanCLJS]), occurrence-t (Fn [(U (Fn [-> BooleanCLJS]) nil) -> BooleanCLJS])}, :props ((! (U false nil) x))}
;"else branch"{:env {x nil, occurrence-t (Fn [(U (Fn [-> BooleanCLJS]) nil) -> BooleanCLJS])}, :props ((is (U false nil) x))}
;"then branch"{:env {x (Fn [-> BooleanCLJS]), occurrence-t (Fn [(U (Fn [-> BooleanCLJS]) nil) -> BooleanCLJS])}, :props ((! (U false nil) x))}
;"else branch"{:env {x nil, occurrence-t (Fn [(U (Fn [-> BooleanCLJS]) nil) -> BooleanCLJS])}, :props ((is (U false nil) x))}
;success
