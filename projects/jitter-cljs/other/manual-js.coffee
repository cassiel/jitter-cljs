this.autowatch = 1

this.myWindow = new JitterObject "jit.window", "WINDOW"
this.myNode = new JitterObject "jit.gl.node", "WINDOW"

this.myNode.name = "NODE"

this.myRender = new JitterObject "jit.gl.render", "WINDOW"

this.myTexts =
        (new JitterObject "jit.gl.text", "NODE") for i in [0..9]

for i in [0..9]
        this.myTexts[i].text "Hello #{i}"

this.myRender = myRender

this.bang = () ->
        this.myRender.erase()
        this.myRender.drawclients()
        this.myRender.swap()

post new Date + "\n"
