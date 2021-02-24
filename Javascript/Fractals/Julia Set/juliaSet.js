var myCanvas = document.createElement("canvas");

const WIDTH = 1920;
const HEIGHT = 1080;

myCanvas.width = WIDTH;
myCanvas.height = HEIGHT;

document.body.appendChild(myCanvas);

var ctx = myCanvas.getContext("2d");

const offsetX = -WIDTH / 2;
const offsetY = -HEIGHT / 2;

const zoomFactor = 400;
const panX = 0;
const panY = 0;

var maxIterations = 100;
const maxValue = 5;

var compX = 0.285;
var compY = 0.01;

function isInJulia(x, y){

    var realNum = x;
    var imagNum = y;

    var i = 0;

    do{

        var tempRealNum = realNum * realNum - imagNum * imagNum;
        var tempImagNum = 2 * realNum * imagNum;

        realNum = tempRealNum + compX;
        imagNum = tempImagNum + compY;

        var sum = realNum * realNum + imagNum * imagNum;

        i++;

    }while(i < maxIterations && sum < maxValue)

    // var sum = Math.sqrt(realNum * realNum + imagNum * imagNum);

    if(sum < maxValue){

        return  [true, i];
    }

    return [false, i];
}

function drawPixel(canvasX, canvasY){

    var pixelValue = isInJulia((canvasX + offsetX) / zoomFactor + panX, -((canvasY + offsetY) / zoomFactor + panY));

    var colormode = parseInt(document.getElementById("colormode").value);

    switch(colormode){
        case 1:
            if(pixelValue[0]){

                ctx.fillStyle = "black";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }else{
            
                var colorFactor = 1 - pixelValue[1] / maxIterations;
                var hslValue = Math.round(255 * colorFactor).toString();
        
                ctx.fillStyle = "hsl(" + hslValue + ", 100%, 50%)";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }
            break;
        case 2:
            if(pixelValue[0]){

                ctx.fillStyle = "black";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }else{
            
                var colorFactor = pixelValue[1] / maxIterations;
                var hslValue = Math.round(255 * colorFactor).toString();
        
                ctx.fillStyle = "hsl(" + hslValue + ", 100%, 50%)";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }
            break;
        case 3:
            if(pixelValue[0]){

                ctx.fillStyle = "black";
                ctx.fillRect(canvasX, canvasY, 1, 1)
            }else{
        
                ctx.fillStyle = "white";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }
            break;
        default:
            if(pixelValue[0]){

                ctx.fillStyle = "black";
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }else{
        
                colorFactor = Math.sqrt(pixelValue[1] / maxIterations);
                colorValue = Math.round(256 * colorFactor).toString(16);
                ctx.fillStyle = "#" + colorValue + colorValue + colorValue;
                ctx.fillRect(canvasX, canvasY, 1, 1);
            }   
    }
}

function startFractal() {
    for(var canvasX = 0; canvasX < WIDTH; canvasX++){   

        for(var canvasY = 0; canvasY < HEIGHT; canvasY++){
    
            drawPixel(canvasX, canvasY);   
        }
    }
}

function drawFractal(){

    var inputX = document.getElementById("inputX").value;
    var inputY = document.getElementById("inputY").value;

    if(inputX != "" && inputY != ""){
        compX = parseFloat(inputX);
        compY = parseFloat(inputY);
    }

    if(document.getElementById("inputIterations").value != ""){
        maxIterations = parseFloat(document.getElementById("inputIterations").value);
    }

    startFractal();
}

setTimeout(startFractal, 100)

// startFractal();