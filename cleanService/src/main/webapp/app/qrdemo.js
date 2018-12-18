$(document).ready(function(){

    var qrcode = new QRCode(document.getElementById("qrcode"), {
        width : 300,
        height : 300
    });

    function makeCode () {
        var self_url = window.location + "?" +new Date().getTime();
        qrcode.makeCode(self_url);
    }

    makeCode();

    // $("#qrcode").
    // on("click", function () {
    //     makeCode();
    // }).
    // on("keydown", function (e) {
    //     if (e.keyCode == 13) {
    //         makeCode();
    //     }
    // });

});