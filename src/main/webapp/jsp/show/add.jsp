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
<script type="text/javascript" src="<%=basePath %>jsp/Js/AjaxFileUploade/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/show/picupload.js"></script>
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


<form  id="showForm" class="definewidth m20">
	<table class="table table-bordered table-hover m10">
	   
	   	<!-- pictures upload function required -->
		<tr>
			<td class="tableleft">图片</td>
			<td>
				<input type="file" id="pic-file" name="pic-file"/>
				<input id="btnUpload" type="button" value="上传" style="width: 60px;" class="btn btn-primary"/>
				<div id="wait_loading" style="padding:0;display:none;">
					<div style="width: 20px;margin: 0 auto;"><span>图片上传中，请稍等...</span></div>
				</div>
			</td>
		</tr>
		<tr>
			<td>图片配文<font size="2px" color="red">(30字以内)</font></td>
			<td><textarea rows="3" cols="10" name="showPicText" maxlength="30"></textarea></td>
		</tr>
		<tr>
			<td>展示顺序</td>
			<td>
				<select name="showPicOrder">
       				<option value="1">1</option>
       				<option value="2">2</option>
       				<option value="3">3</option>
       				<option value="4">4</option>
       				<option value="5">5</option>
       		  </select>
			</td>
		</tr>
		<tr>
			<td>是否可用</td>
			<td>
				<input type="radio" name="showDel" value="0" checked/> 启用
		        <input type="radio" name="showDel" value="1" /> 禁用 
			</td>
		</tr>
		
		<tr id="pic-path-tr" style="display: none">
			<td class="tableleft">图片路径</td>
			<td><input type="text" id="showPicPath" readonly="readonly" name="showPicPath"/></td>
		</tr>

		<tr id="pic-path-url-tr" style="display: none">
			<td class="tableleft">图片对外访问路径</td>
			<td><input type="text" id="showPicUrlPath" readonly="readonly" name="showPicUrlPath"/></td>
		</tr>
		
		<tr  id="pic-name-tr" style="display: none">
	        <td class="tableleft">图片名称</td>
	        <td><input type="text" name="tShowPicName" id="tShowPicName" readonly="readonly"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="button" class="btn btn-primary"  id="saveBut">保存</button>
	            <button type="button" class="btn btn-success" name="backid" id="backid" onclick="goBack()">返回列表</button>
	        </td>
	    </tr>
	</table>
</form>


 <script type="text/javascript">
 
 
 $(function () {
		$('#saveBut').click(function(){
				$.ajax({
					url:"<%=basePath %>show/add",
					data: $('#showForm').serialize(),
					type : "post",
					 async: false,
		             error: function() {
		                 alert("Connection error");
		             },
		             success: function(responseText) {
		            	 alert(responseText);
		            	 if(responseText=='上传成功'){
		            		 window.location.href='<%=basePath %>show/init';
		            	 }
		            	 console.info(responseText);
		             }
				});
		 });
 });
 
 
 

 
 function goBack(){
	 window.location.href='<%=basePath %>show/init';
 }
 
 </script>
</body>
</html>