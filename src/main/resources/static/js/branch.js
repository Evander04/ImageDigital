document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.fixed-action-btn');
    var instances = M.FloatingActionButton.init(elems, {});

    elems = document.querySelectorAll('.modal');
    instances = M.Modal.init(elems,{});
});


document.getElementById("submitBranch").onclick= function () {
        var id=document.getElementById("submitBranch").getAttribute("db");
        console.log(id);
        var json={
          "name": $("#name").val(),
          "telephone": $("#phone").val(),
          "address": $("#address").val()
        };
        console.log(json);

    post("/branch/save",JSON.stringify(json),function(data)
    {
        var jsonResponse=JSON.parse(data);
        console.log(jsonResponse.response);
        location.reload();
    });
};