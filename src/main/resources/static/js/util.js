/**
 * Created by 01436296 on 2017/10/13.
 */
var $utils = {

    upload : function (fileId,successFunction) {
        layer.load();
        var xhr = new XMLHttpRequest();
        xhr.open("POST",'/upload',true);
        xhr.onreadystatechange = function(){
            layer.closeAll('loading');
            if ( xhr.readyState == 4 ) {
                if(xhr.status == 200){
                    successFunction(xhr.responseText)
                } else {
                    alert(xhr.statusText);
                }
            }
        };
        var formdata = new FormData();
        formdata.append("file",document.getElementById(fileId).files[0])
        xhr.send(formdata);
    },
    httpUrl:"http://oxp6k4ur5.bkt.clouddn.com/",
    checkLogin : function(data){
        if(data === '/login'){
            window.location.href = '/login';
        }
    }
}