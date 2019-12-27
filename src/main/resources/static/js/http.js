/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function post(url,data,callback) {

    var http = new XMLHttpRequest();

    http.open("POST", url, true);

//Send the proper header information along with the request
    http.setRequestHeader("Content-type", "application/json");

    http.onreadystatechange = function () {//Call a function when the state changes.
        if (http.readyState == 4 && http.status == 200) {
//            console.log(http.responseText);
            callback(http.responseText);
        }
    };
    http.send(data);

}
function dlete(url,data,callback) {

    var http = new XMLHttpRequest();

    http.open("DELETE", url, true);

//Send the proper header information along with the request
    http.setRequestHeader("Content-type", "application/json");

    http.onreadystatechange = function () {//Call a function when the state changes.
        if (http.readyState == 4 && http.status == 200) {
//            console.log(http.responseText);
            callback(http.responseText);
        }
    };
    http.send(data);

}
function get(url,callback) {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            callback(myArr);
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}