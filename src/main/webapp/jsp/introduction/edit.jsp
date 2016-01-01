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

 
<form action="save" method="post" class="definewidth m20" id="intrForm">
<input type="hidden" name = "comId" value="${introduction.comId }">
<input type="hidden" name = "intrId" value="${introduction.intrId }">
	<table class="table table-bordered table-hover m10">
	  	<tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="button" class="btn btn-primary" type="button" onclick="save()">保存</button>
	        </td>
	    </tr>
	    <tr>
	        <td width="10%" class="tableleft">简介内容<br><font color="red" size="2px"> (200字以内) </font></td>
	        <td> <input type="hidden" name="intrContent" id="intrContent" value=" ${introduction.intrContent }"/> 
	         <script id="editor" type="text/plain"  style="width:1024px;height:300px;"></script>
	        </td>
	        
	    </tr>
	    <tr>
	        <td class="tableleft">公司理念</td>
	        <td><input type="text" name="intrIdea" value=" ${introduction.intrIdea }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">公司宗旨</td>
	        <td><input type="text" name="intrPurpose" value="${introduction.intrPurpose }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">公司目标</td>
	        <td><input type="text" name="instrTerget" value="${introduction.instrTerget }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">公司标语</td>
	       <td><input type="text" name="intrSlogan" value="${introduction.intrSlogan }"/></td>
	    </tr>
	    <tr>
	  
	</table>
</form>


<script type="text/javascript">
var ue = UE.getEditor('editor');

function getContent() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    document.getElementById('intrContent').value=arr;
}

function save(){
	getContent();
		$.ajax({
			url:"<%=basePath %>introduction/save",
			data: $('#intrForm').serialize(),
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

 UE.getEditor('editor').ready(function(){
	var value =  document.getElementById('intrContent').value;
	if(value != ""){
		UE.getEditor('editor').execCommand('insertHtml', value);
	}

});

</script>

</body>
</html>