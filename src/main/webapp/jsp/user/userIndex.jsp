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
				window.location.href="<%=basePath %>menu/addInit";
		 });
    });
    
    
    function delmenu(obj){
    	
    	$.ajax({
			url:"<%=basePath %>menu/delMenu",
			data: 'delid=' + obj ,
			dataType:"json",
			type : "post",
			success:function(data){
				window.location.href="<%=basePath %>menu/init";
			},
			error:function(result){
				alert("网络错误");
			},
		});
    	}
    
    function editMenu(obj){
    	window.location.href="<%=basePath %>menu/editInit?menuId="+obj;
    	
    }
	
</script>

</head>

<body>
<form class="form-inline definewidth m20" >
	<button type="button" class="btn btn-success" id="addnew">新增用户</button><br>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>序号</th>
        <th>用户名称</th>
        <th>用户密码</th>
        <th>公司id</th>
        <th>创建时间</th>
        <th>失效时间</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:forEach var="item" items="${users}" varStatus="status">     
	     <tr>
            <td>${ status.index + 1}</td>
            <td>${item.username}</td>
            <td>${item.password}</td>
            <td>${item.comId}</td>
            <td>${item.begindate}</td>
            <td>${item.enddate}</td>
            <td>
                <a href="javascript:void(0)" onclick="editMenu(${item.id})" >编辑</a>
                <a href="javascript:void(0)" onclick="delmenu(${item.id})" >删除</a>  
            </td>
        </tr>
        </c:forEach>

        </table>
</body>
</html>