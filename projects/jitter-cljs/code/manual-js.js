post("Hello World", Date(), "\n");

this.autowatch = 1;

var myWindow = new JitterObject("jit.window", "WINDOW");

var myRender = new JitterObject("jit.gl.render", "WINDOW");

var myText = new JitterObject("jit.gl.text", "WINDOW");

myText.text("Hello");

function bang() {
    myRender.erase();
    myRender.drawclients();
    myRender.swap();
}
