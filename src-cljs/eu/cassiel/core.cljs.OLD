(ns eu.cassiel.core)

(this-as me
         (set! (.-window me)
               (js/JitterObject. "jit.window" "WINDOW"))

         (set! (.-render me)
               (js/JitterObject. "jit.gl.render" "WINDOW"))

         (let [n (js/JitterObject. "jit.gl.node" "WINDOW")]
           (set! (.-name n) "NODE2")
           (set! (.-node me) n))

         (let [t  (js/JitterObject. "jit.gl.text" "NODE2")]
           (set! (.-color t) (array 1 1 1 1))
           (set! (.-fontsize t) 20)
           (set! (.-depth t) 0.1)
           (set! (.-rotate t) (array 20.0 0.0 0.0 1.0))
           (set! (.-align t) 1)
           (set! (.-material t) "mtl")

           (doto t
             (.font "Courier")
             (.text "Hello"))

           (set! (.-text me) t)
           ))

(defn bang [me]
  (let [r (.-render me)]
    (.erase r)
    (.drawclients r)
    (.swap r)))

(defn closebang [me]
  (set! (.-window me) nil)
  (set! (.-render me) nil)
  (set! (.-text me) nil)
  (set! (.-node me) nil)
  (js/gc)
  (js/post "closebang!\n"))

(this-as me
         (set! (.-bang me) #(bang me))
         (set! (.-closebang me) #(closebang me))
         (set! (.-autowatch me) 1)
         (js/post (str "eu.cassiel.core " (js/Date) "\n")))
