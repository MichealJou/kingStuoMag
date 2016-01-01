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
				window.location.href="<%=basePath %>proGroup/addInit";
		 });
    });
    
    
    function delProGroup(obj){
    	
    	
    	$.ajax({
    		url:"<%=basePath %>proGroup/delProGroup",
			data: 'delid=' + obj ,
    		type : "post",
    		 async: false,
             error: function() {
                 alert("Connection error");
             },
             success: function(responseText) {
            	 if(responseText==' ' || responseText==''){
            		 window.location.href='<%=basePath %>proGroup/init';
            	 }else{
            		 alert(responseText);
            	 }
             }
    	});
    	}
    	
    	
    
    
    function editProGroup(obj){
    	window.location.href="<%=basePath %>proGroup/editInit?proGroupId="+obj;
    	
    }
	
</script>

</head>

<body>
<form class="form-inline definewidth m20" >
	 <button type="button" class="btn btn-success" id="addnew">新增分类</button><br> 
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>序号</th>
        <th>分类名称</th>
        <th>可用状态</th>
        <th>父类名称</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:forEach var="item" items="${proGroups}" varStatus="status">     
	     <tr>
            <td>${ status.index + 1}</td>
            <td>${item.proCategoryName}</td>
            <td>	
                <c:if test="${item.proCategoryStatus == 0}">可用</c:if> 
				<c:if test="${item.proCategoryStatus == 1}">不可用</c:if> 
			</td>
            <td>
				<c:if test="${empty item.pCategoryParName}">该菜单为一级分类</c:if> 
				<c:if test="${not empty item.pCategoryParName}">${item.pCategoryParName}</c:if> 
			</td>
            <td>
                  <a href="javascript:void(0)" onclick="editProGroup(${item.proCategoryId})">编辑</a>
                  <a href="javascript:void(0)" onclick="delProGroup(${item.proCategoryId})" >删除</a>
                  
            </td>
        </tr>
        </c:forEach>

        </table>
</body>
</html>