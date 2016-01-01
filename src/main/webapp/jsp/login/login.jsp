<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE>  

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/jsp/assets/img/logo.png" />
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/jsp/assets/img/logo.png" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/style.css" />
    <script type="text/javascript" src="<%=basePath %>jsp/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/common.js"></script>
<title>登陆</title>  

 <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 300px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }


	
    </style>
    
    <script type="text/javascript">
    
function login(){
	$.ajax({
		url:"<%=basePath %>login/login",
		data: $('#loginForm').serialize(),
		type : "post",
		 async: false,
         error: function() {
             alert("Connection error");
         },
         success: function(responseText) {
        	 if(responseText==' ' || responseText==''){
        		 window.location.href='<%=basePath %>main/init';
        	 }else{
        		 document.getElementById('errorText').innerHTML=responseText;
        		 $("#errorText").show();
        	 }
         }
	});
}
    
    </script>
      
</head>  
<body>  
    <div class="container">  
   <!--   <form action="login" method="post" class="form-signin">  -->
     <form  id="loginForm" " class="form-signin">
        <h2 class="form-signin-heading">登录系统</h2>
         
            <input type="text" name="username" class="input-block-level" placeholder="账号"> 
            <input type="password" name="password"  class="input-block-level" placeholder="密码"> 
         	<!-- <p><button class="btn btn-large btn-primary" type="submit" >登录</button></p> -->
         	<span><font size="2px" color="red" style="display: none" id="errorText">测试</font></span>
         	<p><button class="btn btn-large btn-primary" type="button" onclick="login()" >登录</button></p>
        </form>  
    </div>  
</body>  
</html>  