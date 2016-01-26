var myWindow = new JitterObject("jit.window", "WINDOW");
var myRender = new JitterObject("jit.gl.render", "WINDOW");

var myNode = new JitterObject("jit.gl.node", "WINDOW");
myNode.name = "NODE";

var myText = new JitterObject("jit.gl.text", "NODE");
myText.text("Hello");

function bang() {
    myRender.erase();
    myRender.drawclients();
    myRender.swap();
}

this.myWindow = myWindow;
this.myRender = myRender;
this.myNode = myNode;

post("" + Date() + "\n");
this.autowatch = 1;
