var props = {
    url: "http://192.168.0.34:8083/turnos/turno/windowDescktop",
    height: 250,
    width: 600,
    type: "popup",
	focused: true,
	top:550,
	left: 1000
}

chrome.windows.create(props, function(windowObj){
    console.dir(windowObj);
});

setTimeout(function () {
    location.reload();
}, 5000);