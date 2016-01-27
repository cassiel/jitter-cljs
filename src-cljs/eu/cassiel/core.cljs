(ns eu.cassiel.core
  (:require [eu.cassiel.twizzle :as tw]))

(defn bang [me]
  (swap! (.-state me)
         (fn [{:keys [auto time] :as s}]
           (assoc s
                  :auto (tw/locate auto time)
                  :time (inc time))))
  (let [a @(.-state me)]
    (js/post (str (:auto a) "\n"))
    (.outlet me 0 "rotate_it" (:time a) (tw/sample (:auto a) :X)))
  )

(defn seek
  "Seek to a rotation"
  [me msec degrees]
  (swap! (.-state me)
         update :auto tw/automate-in :X 0 msec degrees))

(this-as me
         (set! (.-state me) (atom {:auto (tw/initial :init {:X 0.0})
                                   :time 0}))
         (set! (.-seek me) (partial seek me))
         (set! (.-bang me) (partial bang me))

         (set! (.-autowatch me) 1)
         (js/post (str "eu.cassiel.core " (js/Date) "\n")))
