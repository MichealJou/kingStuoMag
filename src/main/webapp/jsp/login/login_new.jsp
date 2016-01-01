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
 	<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/style.css" />
    <script type="text/javascript" src="<%=basePath %>jsp/Js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/bootstrap.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/ckform.js"></script>
    <script type="text/javascript" src="<%=basePath %>jsp/Js/common.js"></script>
<title>登陆</title>  

 <style type="text/css">
      body{
			background:url(<%=basePath %>jsp/Images/woodTexture.png) repeat;
		}
		#loginpageMain{
			width:495px;
			height:410px;
			background:url(<%=basePath %>jsp/Images/loginbg.png) no-repeat;
			margin:153px auto 0 auto;
		}
		#loginpageMain-title{
			color: #fff;
			font-size: 32px;
			padding: 22px 0 0 75px;
		}
		#loginpageMain-form{
			padding: 60px 43px 0 43px;
		}
		.loginpageMain-form-input{
			margin: 0 0 15px 0;
			height: 51px;
			font-size: 28px;
		}
    </style>
    
    <script type="text/javascript">
    
function login(){
	$.ajax({
		url:"<%=basePath %>login/login",
		data: $('#loginpageMain-form').serialize(),
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
<!--     <div class="loginpageMain">  
     <form action="login" method="post" class="form-signin"> 
     <form  id="loginForm"  class="form-signin">
        <h2 class="form-signin-heading">登录系统</h2>
         
            <input type="text" name="username" class="input-block-level" placeholder="账号"> 
            <input type="password" name="password"  class="input-block-level" placeholder="密码"> 
         	<p><button class="btn btn-large btn-primary" type="submit" >登录</button></p>
         	<span><font size="2px" color="red" style="display: none" id="errorText">测试</font></span>
         	<p><button class="btn btn-large btn-primary" type="button" onclick="login()" >登录</button></p>
        </form>  
    </div>  --> 
    
    
    
    <div id="loginpageMain">
		<h1 id="loginpageMain-title">凯旋思拓后台管理系统</h1>
		<form id="loginpageMain-form" >
			<div class="form-group">
				<input type="text" name="username" style="margin: 0 0 15px 0;height: 51px;font-size: 23px;width: 400px" placeholder="请输入登陆账号"> 
				<input type="password" name="password"  style="margin: 0 0 15px 0;height: 51px;font-size: 23px;width: 400px" placeholder="请输入登陆密码"> 
			</div>
			<div>
			  	<span><font size="2px" color="red" style="display: none" id="errorText">测试</font></span>
			  	<br>
			  	<br>
			  	
				<p><button  type="button" onclick="login()" style="margin-left:40%;  width: 85px;height: 32px;background-image:url(<%=basePath %>jsp/Images/subBut.png) ;" ><font size="5"></font></button>
				</p>
			</div>
		</form>
	</div>
</body>  
</html>  