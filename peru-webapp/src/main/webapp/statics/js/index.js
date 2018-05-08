function login(){
    $.ajax({
        type: "POST",
        url:  "/login",
        data:  {email:$("#inputEmail").val(), password:$("#inputPassword").val()},
        success: function(data) {
            location.href = "/report.html"
        } ,
        error: function(jqXHR, textStatus, errorThrown){
            var msg = JSON.stringify(jqXHR);
            alert(msg);
        }
    });
}