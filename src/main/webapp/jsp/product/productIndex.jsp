<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				window.location.href="<%=basePath %>product/addInit";
		 });
    });
    
    
    function delPro(obj){
    	
    	$.ajax({
			url:"<%=basePath %>product/delProduct",
			data: 'delid=' + obj ,
			dataType:"json",
			type : "post",
			success:function(data){
				window.location.href="<%=basePath %>product/init";
			},
			error:function(result){
				alert("网络错误");
			},
		});
    	}
    
    function editPro(obj){
    	window.location.href="<%=basePath %>product/editInit?editId="+obj;
    	
    }
	
</script>

</head>

<body>
<form class="form-inline definewidth m20" >
	<button type="button" class="btn btn-success" id="addnew">新增产品</button><br>
</form>
<table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>序号</th>
        <th>产品图片</th>
        <th>产品名称</th>
        <th>产品分类</th>
        <th>产品简介</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:forEach var="item" items="${products}" varStatus="status">     
	     <tr>
            <td>${ status.index + 1}</td>
            <td>
            	<img alt="未上传图片" src=" ${item.proPicUrlPath}" style="width: 100px;height: 100px">
            </td>
            <td>${item.proName}</td>
            <td>${item.pName}</td>
            <td>
                 <c:if test="${fn:length(item.proDesc)>'10'}">
                   ${fn:substring(item.proDesc,0,10)}... 
                 </c:if>
                 <c:if test="${fn:length(item.proDesc)<='13'}">
                   ${item.proDesc}
                 </c:if>
			</td>
            <td>
                  <a href="javascript:void(0)" onclick="editPro(${item.proId})">编辑</a>
                  <a href="javascript:void(0)" onclick="delPro(${item.proId})" >删除</a>
                  
            </td>
        </tr>
        </c:forEach>

        </table>
</body>
</html>