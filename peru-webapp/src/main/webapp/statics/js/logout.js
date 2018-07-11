function logout(){
    $.ajax({
        type: "GET",
        url:  "/logout",
        success: function(data) {
            location.href = "/index.html"
        } ,
        error: function(jqXHR, textStatus, errorThrown){
            var msg = JSON.stringify(jqXHR);
            alert(msg);
        }
    });
}/**
 * Created by roger.lu on 2018/7/12.
 */
