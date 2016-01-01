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

 
<form action="update" method="post" class="definewidth m20">
<input type="hidden" name="id" value="${productCategory.proCategoryId }">
	<table class="table table-bordered table-hover m10">
	    <tr>
	        <td width="10%" class="tableleft">上级</td>
	        <td>
	            <%-- <select name="tParentId" >
		            <c:forEach var="item" items="${menus}" varStatus="status">   
		            <c:choose>
		             <c:when test="${item.id eq menu.tParentId}">
		            	<option value="${item.id}"  selected = "selected">${item.tMenuName}</option>
		             </c:when>
		             <c:when test="${menu.tParentId eq 0}">
		             	<option value="0"  selected = "selected">该菜单为一级菜单</option>
		             </c:when>
		              <c:otherwise>
		              	<option value="${item.id}"  >${item.tMenuName}</option>
		              </c:otherwise>
		              </c:choose>
		            </c:forEach>
	            </select> --%>
	            
	               <select name="proCategoryParentId" >
	             	<c:choose>
					 		<c:when test="${productCategory.proCategoryParentId eq 0}">
		             			<option value="0"  selected = "selected">该分类为一级分类</option>
		             		</c:when>
		             		<c:otherwise>
		              			<option value="0" >新建一级分类</option>
		              		</c:otherwise>
	            		</c:choose>
		           <c:if test="${!empty lv_1}">
		             <optgroup label="一级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_1}" varStatus="status">  
	            			<c:choose>
	            				<c:when test="${item.proCategoryId eq productCategory.proCategoryParentId}">
		            				<option value="${item.proCategoryId}"  selected = "selected">${item.proCategoryName}</option>
		             			</c:when>
		             			<c:otherwise>
		              				<option value="${item.proCategoryId}" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		              			</c:otherwise>
	            			</c:choose>
		            		
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           <c:if test="${!empty lv_2}"  >
		             <optgroup label="二级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_2}" varStatus="status">  
		            		
		            		<c:choose>
	            				<c:when test="${item.proCategoryId eq productCategory.proCategoryParentId}">
		            				<option value="${item.proCategoryId}"  selected = "selected">${item.proCategoryName}</option>
		             			</c:when>
		             			<c:otherwise>
		              				<option value="${item.proCategoryId}" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		              			</c:otherwise>
	            			</c:choose>
		            		
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           <c:if test="${!empty lv_3}" >
		             <optgroup label="三级分类" style="background-color: #F0F8FF">
	            		<c:forEach var="item" items="${lv_3}" varStatus="status">  
		            		<c:choose>
	            				<c:when test="${item.proCategoryId eq productCategory.proCategoryParentId}">
		            				<option value="${item.proCategoryId}"  selected = "selected">${item.proCategoryName}</option>
		             			</c:when>
		             			<c:otherwise>
		              				<option value="${item.proCategoryId}" style="background-color: #FFFFFF">${item.proCategoryName}</option>
		              			</c:otherwise>
	            			</c:choose>
		            	</c:forEach>
			         </optgroup>
		           </c:if>
		           
	            </select>
	            
	        </td>
	    </tr>
	    <tr>
	        <td class="tableleft">分类名称</td>
	        <td><input type="text" name="proCategoryName" value=" ${productCategory.proCategoryName }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">分类描述</td>
	        <td><input type="text" name="proCategoryDesc" value="${productCategory.proCategoryDesc }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">是否可用</td>
	        <td>
	         	<c:if test="${productCategory.proCategoryStatus == '0'}">
		        	<input type="radio" name="proCategoryStatus" value="0" checked/> 启用
		        	<input type="radio" name="proCategoryStatus" value="1" /> 禁用 
	        	</c:if>
	       	 	<c:if test="${productCategory.proCategoryStatus == '1'}">
	       	 		<input type="radio" name="proCategoryStatus" value="0" /> 启用
		        	<input type="radio" name="proCategoryStatus" value="1" checked /> 禁用 
	       	 	</c:if>
	        
	        </td>
	    </tr>
	  
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