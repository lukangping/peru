$.ajax({
    type: "GET",
    url:  "/facebook/accounts",
    success: function(data) {
        if(data.success) {
            for (var i = 0; i < data.data.length; i++) {
                $("#facebookSelect").append($("<option></option>")
                    .attr("value",data.data[i].facebookId)
                    .text(data.data[i].facebookId));

            }
        }
    } ,
    error: function(jqXHR, textStatus, errorThrown){
        var msg = JSON.stringify(jqXHR);
        alert(msg);
    }
});

function report(){
    console.log("report.")
}