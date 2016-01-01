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
 
 
 <script type="text/javascript">
	 function goBack(){
		 window.location.href='<%=basePath %>proGroup/init';
	 }
 </script>
 
</head>
<body>


<form action="add" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover m10">
	    <tr>
	        <td width="10%" class="tableleft">上级</td>
	        <td>
	            <select name="proCategoryParentId" >
	            	<option value="0" >新建一级分类</option>
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
		            		<option value="${item.proCategoryId}" disabled="disabled" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           
	            </select>
	        </td>
	    </tr>
	    <tr>
	        <td class="tableleft">分类名称</td>
	        <td><input type="text" name="proCategoryName"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">分类描述</td>
	        <td><input type="text" name="proCategoryDesc"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">是否可用</td>
	        <td>
				<input type="radio" name="proCategoryStatus" value="0" checked/> 启用
		        <input type="radio" name="proCategoryStatus" value="1" /> 禁用 
			</td>
	    </tr>
	    <tr>
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
	            <button type="button" class="btn btn-success" name="backid" id="backid" onclick="goBack()">返回列表</button>
	        </td>
	    </tr>
	</table>
</form>
</body>
</html>