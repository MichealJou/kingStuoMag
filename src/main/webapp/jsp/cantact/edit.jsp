<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>



<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/style.css" />
<script type="text/javascript" src="<%=basePath %>jsp/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/ckform.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/common.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/emailAutoComplete.js"></script>

<title>Insert title here</title>


<style type="text/css">
     body {
         padding-bottom: 40px;
     }
     .sidebar-nav {
         padding: 9px 0;
     }

     @media (max-width: 980px) {
         /* Enable use of floated navbar text */
         .navbar-text.pull-right {
             float: none;
             padding-left: 5px;
             padding-right: 5px;
         }
     }
     
     ul, li {
				list-style:none;
				margin-left: 0px;
				padding-left:0px;
			}
			
	.auto-tip li {
		border:1px solid #ccc;
		background:#ddd;
		font:12px/20px Tahoma;
	}
	.auto-tip li.hoverBg {
		background:#B0C4DE;
		cursor:pointer;
	}
	.red {
		color:#333;
	}
	.hidden {
		display:none;
	}
</style>
 
 
 
 
</head>
<body>

 
<form action="save" method="post" class="definewidth m20" id="canForm">
<input type="hidden" name = "comId" value="${cantact.comId }">
<input type="hidden" name = "conId" value="${cantact.conId }">
	<table class="table table-bordered table-hover m10">
	  	<tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="button" class="btn btn-primary" type="button" onclick="save()">保存</button>
	        </td>
	    </tr>
	    <tr>
	        <td width="10%" class="tableleft">通讯地址<br><font color="red" size="2px"> </font></td>
	        <td> <input type="text" name="conAddress" value=" ${cantact.conAddress }"/>
	        </td>
	        
	    </tr>
	    <tr>
	        <td class="tableleft">邮编</td>
	        <td><input type="text" name="conCode" value=" ${cantact.conCode }" onkeyup="this.value=this.value.replace(/\D/g,'')"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">邮箱</td>
	        <td>
	        	<div class="parentCls">
	        		<input type="text" name="conEmail" class="inputElem" value="${cantact.conEmail }"/>
	        	</div>
	        </td>
	    </tr>
	    <tr>
	        <td class="tableleft">咨询电话</td>
	        <td><input type="text" name="conTel" value="${cantact.conTel }" onkeyup="this.value=this.value.replace(/\D/g,'')" /></td>
	    </tr>
	    <tr>
	        <td class="tableleft">公司主页网址</td>
	       <td><input type="text" name="conPage" value="${cantact.conPage }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">咨询电话对应人</td>
	       <td><input type="text" name="conTelMan" value="${cantact.conTelMan }"/></td>
	    </tr>
	  
	</table>
</form>


<script type="text/javascript">

function save(){
		$.ajax({
			url:"<%=basePath %>cantact/save",
			data: $('#canForm').serialize(),
			type : "post",
			 async: false,
             error: function(request) {
                 alert("Connection error");
             },
             success: function(data) {
            	 alert("success！");
             }
		});
	 
}


</script>

</body>
</html>