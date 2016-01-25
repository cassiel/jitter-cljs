(ns eu.cassiel.core)

(this-as me
         (set! (.-autowatch me) 1)
         (js/post (str "Hello. "(js/Date) "\n")))
