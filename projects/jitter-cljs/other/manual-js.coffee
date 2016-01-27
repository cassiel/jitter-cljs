this.autowatch = 1

this.myWindow = new JitterObject "jit.window", "WINDOW"
this.myRender = new JitterObject "jit.gl.render", "WINDOW"

this.myNodes =
        (new JitterObject "jit.gl.node", "WINDOW") for i in [0..9]

for n, i in this.myNodes
        n.name = "NODE_#{i}"
        n.position = [0, (i - 4.5) / 10, 0]

this.myTexts =
        (new JitterObject "jit.gl.text", "NODE_#{i}") for i in [0..9]

for t, i in this.myTexts
        t.color = [1, 1, 1, 1]
        t.fontsize = 5
        t.align = 1
        t.position = [0, -0.3, 0]
        t.mode = "3d"
        t.font "Courier"
        t.text "Hello #{i}"

this.bang = () ->
        r = this.myRender
        r.erase()
        r.drawclients()
        r.swap()

this.die = () ->
        this.myTexts = []
        gc()

this.rotation = (i, degrees) ->
        this.myNodes[i].rotate = [degrees, 0, 0, 1]

post "manual-js.coffee #{Date()}\n"
