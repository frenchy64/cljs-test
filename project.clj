(defproject cljs-test "0.1.0-SNAPSHOT"
  :description "A simple example of how to use lein-cljsbuild"
  ; Source paths for Leiningen 2.x:
  :source-paths ["src"]
  :dependencies [[org.clojure/clojure "1.5.0-beta1"]
                 [typed "0.1.3"]]
  :plugins [[lein-cljsbuild "0.2.9"]]
  :cljsbuild {
              :builds [{:source-path "src-cljs"
                        :compiler {:output-to "resources/public/js/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]})
