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
 
 
 
 
</head>
<body>

 
<form action="update" method="post" class="definewidth m20">
<input type="text" name="id" value="${menu.id }">
	<table class="table table-bordered table-hover m10">
	    <tr>
	        <td width="10%" class="tableleft">上级</td>
	        <td>
	            <select name="tParentId" >
		            <c:forEach var="item" items="${menus}" varStatus="status">   
		            <c:choose>
		             <c:when test="${item.id eq menu.tParentId}">
		            	<option value="${item.id}"  selected = "selected">${item.tMenuName}</option>
		             </c:when>
		             <c:when test="${item.id eq menu.id}">
		             </c:when>
		              <c:otherwise>
		              	<option value="${item.id}"  >${item.tMenuName}</option>
		              </c:otherwise>
		              </c:choose>
		            </c:forEach>
	            </select>
	        </td>
	    </tr>
	    <tr>
	        <td class="tableleft">菜单名称</td>
	        <td><input type="text" name="tMenuName" value=" ${menu.tMenuName }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">链接地址</td>
	        <td><input type="text" name="tLink" value="${menu.tLink }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">显示顺序</td>
	        <td><input type="text" name="tSort" value="${menu.tSort }"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">显示位置</td>
	        <td>
 				<select name="tType" >
 				  <c:if test="${menu.tType == 'top'}">  
		           	<option value="top" selected ="selected">顶部</option>
		           	 <option value="bottom">底部</option>
		          </c:if>
		          <c:if test="${menu.tType == 'bottom'}">  
		            <option value="bottom" selected ="selected">底部</option>
		            	<option value="top" >顶部</option>
		          </c:if>
	            </select>
			</td>
	    </tr>
	    <tr>
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