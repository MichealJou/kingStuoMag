<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>jsp/Css/style.css" />
<script type="text/javascript" src="<%=basePath %>jsp/Js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/ckform.js"></script>
<script type="text/javascript" src="<%=basePath %>jsp/Js/common.js"></script>
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

<script>
    $(function () {
		$('#addnew').click(function(){
				var typeId = document.getElementById("artType").value;
				window.location.href="<%=basePath %>article/addInit?typeId="+typeId;
		 });
    });
    
    
    function delArticle(obj){
    	var typeId = document.getElementById("artType").value;
    	$.ajax({
			url:"<%=basePath %>article/delArticle",
			data: 'delid=' + obj ,
			dataType:"json",
			type : "post",
			success:function(data){
				window.location.href="<%=basePath %>article/init?typeId="+typeId;
			},
			error:function(result){
				alert("网络错误");
			},
		});
    	}
    
    function editArticle(obj){
    	window.location.href="<%=basePath %>article/editInit?articleId="+obj;
    	
    }
	
</script>

</head>

<body>
<input type="hidden" id="artType" value="${artType}">

<form class="form-inline definewidth m20" >
	<button type="button" class="btn btn-success" id="addnew">新建文章</button><br>
</form>

<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>序号</th>
        <th>文章标题</th>
        <th>创建时间</th>
        <th>文章状态</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:forEach var="item" items="${articles}" varStatus="status">     
	     <tr>
            <td>${ status.index + 1}</td>
            <td>${item.artTitle}</td>
            <td>
            	<fmt:formatDate value="${item.artCreateTime}" pattern="yyyy-MM-dd HH:mm:ss" /> 
            </td>
            
            <td>
            	<c:if test="${item.artStatus == 0}">可用</c:if>
            	<c:if test="${item.artStatus == 1}">停用</c:if>
           	</td>
            <td>
                  <a href="javascript:void(0)" onclick="editArticle(${item.artId})">编辑</a>
				  <a href="javascript:void(0)" onclick="delArticle(${item.artId})" >删除</a>
            </td>
        </tr>
    </c:forEach>

        </table>
</body>
</html>