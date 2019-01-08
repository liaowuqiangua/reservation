    $(function() {
        $.ajax({
            type : "get",
            url : "/init",
            dataType : "text",
            success : function(result) {
                if(result === ''){
                     $("#logined").hide();
                     $("#noLogin").show();
                }
                else{
                     var val = $.parseJSON(result);
                     $("#showID").text(val.username);
                     if(val.images.length !== 0){
                        $("#avatar").attr('src',val.images[0].path);
                     }
                     $("#logined").show();
                     $("#noLogin").hide();
                }
            },
            error : function() {
                alert("請求失敗");
            }
        });
    });