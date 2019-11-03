var img = document.getElementById("auto");

var index = 6;
setInterval(function () {
    index--;
    img.src = "./img/banner" + index + ".jpg";
    if (index === 1) {
        index = 6;
    }
}, 1500);
