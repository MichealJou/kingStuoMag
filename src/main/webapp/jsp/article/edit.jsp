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
<script type="text/javascript" src="<%=basePath %>jsp/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/ueditor/ueditor.all.min.js"></script>
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
</style>
 
 
 
 
</head>
<body>

 
<form  method="post" class="definewidth m20" id="artForm">
	<input type="hidden" name="artType" id="artType" value="${article.artType}">
	<input type="hidden" name="artId" value="${article.artId}">
	<input type="hidden" name="artCreateTime" value="${article.artCreateTime}">
	<input type="hidden" name="comId" value="${article.comId}">
	<input type="hidden" name="artContent" id="artContent" value="${article.artContent }"/> 
	<table class="table table-bordered table-hover m10">
	     <tr>
	        <td class="tableleft">标题</td>
	        <td><input type="text" name="artTitle" value="${article.artTitle }"/></td>
	    </tr>
	    <tr>
	        <td width="10%" class="tableleft">内容</td>
	        <td>
	         <script id="editorArtE" type="text/plain"  style="width:1024px;height:300px;"></script>
	        </td>
	        
	    </tr>
	    <tr>
	        <td class="tableleft">状态</td>
	        <td>
	        	<c:if test="${article.artStatus == '0'}">
		        	<input type="radio" name="artStatus" value="0" checked/> 启用
		        	<input type="radio" name="artStatus" value="1" /> 禁用 
	        	</c:if>
	       	 	<c:if test="${article.artStatus == '1'}">
	       	 		<input type="radio" name="artStatus" value="0" /> 启用
		        	<input type="radio" name="artStatus" value="1" checked /> 禁用 
	       	 	</c:if>
	        </td>
	        	
	    </tr>
	  
	  	<tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="button" class="btn btn-primary" type="button" onclick="save()">保存</button>
	            <button type="button" class="btn btn-primary" type="button" onclick="goBack()">返回列表</button>
	        </td>
	    </tr>
	</table>
</form>


<script type="text/javascript">
var ue = UE.getEditor('editorArtE');

function getContent() {
    var arr = [];
    arr.push(UE.getEditor('editorArtE').getContent());
    document.getElementById('artContent').value=arr;
}

function save(){
	getContent();
	var typeId = document.getElementById("artType").value;
		$.ajax({
			url:"<%=basePath %>article/update",
			data: $('#artForm').serialize(),
			type : "post",
			 async: false,
             error: function(request) {
                 alert("Connection error");
             },
             success: function(data) {
            	 window.location.href="<%=basePath %>article/init?typeId="+typeId;
             }
		});
	 
}


UE.getEditor('editorArtE').ready(function(){
	var value =  document.getElementById('artContent').value;
	if(value != ""){
		UE.getEditor('editorArtE').execCommand('insertHtml', value);
	}

});


function goBack(){
	var typeId = document.getElementById("artType").value;
	window.location.href="<%=basePath %>article/init?typeId="+typeId;
}

</script>

</body>
</html>