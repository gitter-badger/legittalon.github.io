(ns theghostinme.core
  (:require
		[dommy.utils :as utils]
		[dommy.core :as dommy])
  (:use-macros
	  [dommy.macros :only [node sel sel1]]))

(dommy/listen! (sel1 :window)
							 :scroll ())

