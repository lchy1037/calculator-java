var HTTP_METHOD = "POST";
var HTTP_URL = "http://127.0.0.1:8080/calculate";

function calculate() {
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var oper = document.getElementById("oper").value;

    var req = {
        "num1": parseInt(num1),
        "oper": oper,
        "num2": parseInt(num2)
    };
    console.log(req);
    var xhr = new XMLHttpRequest();
    xhr.open(HTTP_METHOD, HTTP_URL, true);
    xhr.setRequestHeader("Access-Control-Allow-Headers", "*");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.setRequestHeader("Access-Control-Allow-Origin", "*");
    xhr.send(JSON.stringify(req));

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var resp = xhr.responseText;
            var obj = JSON.parse(resp);
            if (obj["returnCode"] === 0) {
                document.getElementById("result").value = obj["result"];
            } else {
                document.getElementById("result").value = obj["returnMsg"];
            }
        }
    };
}