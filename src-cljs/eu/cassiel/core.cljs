(ns eu.cassiel.core)

(this-as me
         (set! (.-myWindow me) (js/JitterObject. "jit.window" "WINDOW"))
         (set! (.-myRender me) (js/JitterObject. "jit.gl.render" "WINDOW"))
         (set! (.-myText me) (js/JitterObject. "jit.gl.text" "WINDOW"))

         (let [t (.-myText me)]
           (set! (.-color t) (array 1 1 1 1))
           (set! (.-fontsize t) 20)
           (set! (.-align t) 1)
           (set! (.-material t) "mtl")

           (doto t
             (.font "Courier")
             (.text "Hello"))))

(defn bang [me]
  (let [r (.-myRender me)]
    (.erase r)
    (.drawclients r)
    (.swap r)))

(this-as me
         (set! (.-bang me) #(bang me))
         (set! (.-autowatch me) 1)
         (js/post (str "eu.cassiel.core " (js/Date) "\n")))

(this-as me (bang me))
