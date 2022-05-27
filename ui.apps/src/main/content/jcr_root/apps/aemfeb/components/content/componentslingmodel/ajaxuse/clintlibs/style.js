alert("ajax srvlets calling starts");
$(document).on("click","#somebutton",function(){
	alert("ajax srvlets after  starts");
    $.get("/bin/ajaxposttext",function(responseText){
        var json=JSON.stringify(responseText);
        alert('response from server.......'+json);
              $("#somediv").text(json);
    });
});