(defproject theghostinme-cljs "0.1.0-SNAPSHOT"
  :plugins [[lein-cljsbuild "1.0.3"]]
  :description "The dynamic side of theghostin.me"
  :url "http://theghostin.me"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
								 [org.clojure/clojurescript "0.0-2356"]]
  :main ^:skip-aot theghostinme-cljs.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}

	:cljsbuild {
		:builds [{
			; The path to the top-level ClojureScript source directory:
			:source-paths ["src"]
			; The standard ClojureScript compiler options:
			; (See the ClojureScript compiler documentation for details.)
			:compiler {
				:output-to "target/main.js"  ; default: target/cljsbuild-main.js
				:optimizations :whitespace
				:pretty-print true}}]})
