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
	<script type="text/javascript" src="<%=basePath %>jsp/product/picupload.js"></script>
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


<form action="add" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover m10">
	    <tr>
	        <td class="tableleft">产品分类</td>
	        <td>
				  <%-- <select name="productGroupId" >
		            <c:forEach var="item" items="${groups}" varStatus="status">     
		            	<option value="${item.proCategoryId}">${item.proCategoryName}</option>
		            </c:forEach>
	            </select>
	             --%>
	            
	               <select name="productGroupId" >
		           <c:if test="${!empty lv_1}">
		             <optgroup label="一级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_1}" varStatus="status">  
		            		<option value="${item.proCategoryId}" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           <c:if test="${!empty lv_2}"  >
		             <optgroup label="二级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_2}" varStatus="status">  
		            		<option value="${item.proCategoryId}" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           <c:if test="${!empty lv_3}" >
		             <optgroup label="三级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_3}" varStatus="status">  
		            		<option value="${item.proCategoryId}"  style="background-color: #FFFFFF">${item.proCategoryName}</option>
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           
	            </select>
			</td>
	    </tr>
	    <tr>
	        <td class="tableleft">产品名称</td>
	        <td><input type="text" name="proName"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">产品简介</td>
	        <td>
	        	<textarea rows="5" cols="10" name="proDesc"></textarea>
	        </td>
	    </tr>
	   
	   	<!-- pictures upload function required -->
		<tr>
			<td class="tableleft">产品图片</td>
			<td>
				<img alt="未上传图片" style="width: 100px;height: 100px;display: none" id="showPic" src=""><br>
				<input type="file" id="pic-file" name="pic-file"/>
				<input id="btnUpload" type="button" value="上传" style="width: 60px;" class="btn btn-primary"/>
				<div id="wait_loading" style="padding:0;display:none;">
					<div style="width: 20px;margin: 0 auto;"><span>图片上传中，请稍等...</span></div>
				</div>
			</td>
		</tr>
		 <tr id="pic-name-tr" style="display: none">
	        <td class="tableleft">产品图片名称</td>
	        <td><input type="text" id="proPicName" name="proPicName" readonly="readonly"/></td>
	    </tr>
		
		<tr id="pic-path-tr" style="display: none">
			<td class="tableleft">图片路径</td>
			<td><input type="text" id="proPicPath" name="proPicPath" readonly="readonly"/></td>
		</tr>

		<tr id="pic-path-url-tr" style="display: none">
			<td class="tableleft">图片对外访问路径</td>
			<td><input type="text" id="proPicUrlPath" name="proPicUrlPath" readonly="readonly"/></td>
		</tr>
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
	        </td>
	    </tr>
	</table>
</form>
</body>
</html>