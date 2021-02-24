//const WIDTH = window.innerWidth;
//const HEIGHT = window.innerHeight;

const WIDTH = 1920;
const HEIGHT = 1080;

var myCanvas = document.createElement("canvas");
myCanvas.width = WIDTH;
myCanvas.height = HEIGHT;
document.body.appendChild(myCanvas);

var ctx = myCanvas.getContext("2d");
//ctx.canvas.width = WIDTH;
//ctx.canvas.height = HEIGHT;

const maxIterations = 255;
const limit = 5;



function mandelbrotSetCheck(x, y){
    
    var i = 0;
    var realX = x;
    var imagY = y;

    do{
        var tempX = realX * realX - imagY * imagY + x;
        var tempY = 2 * realX * imagY + y;
        realX = tempX;
        imagY = tempY;

        //var d = realX * imagY;
        var d = Math.sqrt(Math.pow(realX, 2) + Math.pow(imagY, 2))
        //var d = realX * realX + imagY * imagY;

        i++;

    } while(i < maxIterations && d < limit)

    return [i/maxIterations * 100, d < limit, i];
}

/*

function mandelbrotSetCheck(x, y){
    
    var realX = x;
    var imagY = y;

    for(var i = 0; i < maxIterations; i++){
        var tempX = realX * realX - imagY * imagY + x;
        var tempY = 2 * realX * imagY + y;
        realX = tempX;
        imagY = tempY;

        var d = realX * imagY;
        //var d = Math.sqrt(Math.pow(realX, 2) + Math.pow(imagY, 2))
        //var d = realX * realX + imagY * imagY;
    }

    return [i/maxIterations * 100, d < limit, i];
}

*/

const colors = new Array(16).fill(0).map((_, i) => i === 0 ? '#000' : `#${((1 << 24) * Math.random() | 0).toString(16)}`)

var zoomFactor = 400;
var panX = 0;
var panY = 0;

for(var x = 0; x < WIDTH; x++){
    for(var y = 0; y < HEIGHT; y++){
        
        var belongsToSet = mandelbrotSetCheck(x / zoomFactor - panX, y / zoomFactor - panY);
        
        if(belongsToSet[1]) {
            ctx.fillStyle = "black";
            ctx.fillRect(x,y, 1,1); // Draw a black pixel
        }else {
            var color = belongsToSet[2].toString(16);

            ctx.fillStyle = '#' + color + color + color;
            //ctx.fillStyle = 'hsl(0, 100%, ' + belongsToSet[0] + '%)';
            //ctx.fillStyle = colors[belongsToSet[1] ? 0 : (belongsToSet[2] % colors.length - 1) + 1]
            
            ctx.fillRect(x,y, 1,1); // Draw a colorful pixel
        }
        
    }
}