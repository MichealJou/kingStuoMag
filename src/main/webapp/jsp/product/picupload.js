$(function(){
    //上传图片
    $("#btnUpload").click(function() {

        if(!$("#pic-file").val()){
            alert("请选择图片！");
            return;
        }

        $("#wait_loading").ajaxStart(function() {// 开始上传文件时显示一个图片
            $(this).show();

        }).ajaxComplete(function() {// 文件上传完成将图片隐藏起来
            $(this).hide();
        });

        var elementIds=["flag"]; //flag为id、name属性名
        $.ajaxFileUpload({
            url: '/kingStuoMag/uploadimg',
            type: "POST" ,
            data:{
            },
            secureuri: false, //一般设置为false
            fileElementId: 'pic-file', // 上传文件的id、name属性名
            dataType: 'json', //返回值类型，一般设置为json、application/json
            elementIds: elementIds, //传递参数到服务器
            success: function(data){
                if(data.uploadRst.indexOf("200-ok") > -1){
                     var div = document.getElementById("showPic");
                  
                     if(div.style.display == "none"){
                     	div.style.display = "block";
                     }
                     div.src=data.picUrlPath;
                	
                    $("#proPicPath").val(data.picPath);
                    $("#proPicUrlPath").val(data.picUrlPath);
                    $("#proPicName").val(data.picName);
                    $("#pic-path-tr").show();
                    $("#pic-name-tr").show();
                    $("#pic-path-url-tr").show();
                   
                    
                }else{
                    alert("上传图片素材失败!");
                    console.log(data);
                }
            },
            error: function(data, status, e){
                console.log(e)
            }
        });
    });
});
