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
				window.location.href="<%=basePath %>show/addInit";
		 });
    });
    
    
    function editShow(obj){
    	var showPicText = "showPicText"+obj;
    	var showDelContext="showDelContext"+obj;
    	var showDelSelect="showDelSelect"+obj;
    	var showOrderContext="showOrderContext"+obj;
    	var showOrderSelect="showOrderSelect"+obj;
    	var editBut="editBut"+obj;
    	var saveBut="saveBut"+obj;
    	var cancelBut="cancelBut"+obj;
    	
    	
    	document.getElementById(showPicText).readonly = true;
    	document.getElementById(showDelContext).style.display = 'none';
    	document.getElementById(showOrderContext).style.display = 'none';
    	document.getElementById(editBut).style.display = 'none';
    	document.getElementById(showDelSelect).style.display = 'block';
    	document.getElementById(showOrderSelect).style.display = 'block';
    	document.getElementById(saveBut).style.display = 'block';
    	document.getElementById(cancelBut).style.display = 'block';
    	
    	
    	
    }
    
    function cancelShow(obj){
    	var showPicText = "showPicText"+obj;
    	var showDelContext="showDelContext"+obj;
    	var showDelSelect="showDelSelect"+obj;
    	var showOrderContext="showOrderContext"+obj;
    	var showOrderSelect="showOrderSelect"+obj;
    	var editBut="editBut"+obj;
    	var saveBut="saveBut"+obj;
    	var cancelBut="var"+obj;
    	
    	document.getElementById(showPicText).readonly = true;
    	document.getElementById(showDelContext).style.display = 'block';
    	document.getElementById(showOrderContext).style.display = 'block';
    	document.getElementById(editBut).style.display = 'block';
    	document.getElementById(showDelSelect).style.display = 'none';
    	document.getElementById(showOrderSelect).style.display = 'none';
    	document.getElementById(saveBut).style.display = 'none';
    	document.getElementById(cancelBut).style.display = 'none';
    	
    	
    	
    }
    
    
    
    
    function saveShow(obj1,obj2){
    	var showPicText = "showPicText"+obj2;
    	var showDelSelect="showDelSelect"+obj2;
    	var showOrderSelect="showOrderSelect"+obj2;
    	var showDel ="showDel"+obj2;
    	var showOrder="showOrder"+obj2;
    	
    	var text =	document.getElementById(showPicText).value;
    	var delVal;
    	var chkObjs = document.getElementsByName(showDel);
    	 for(var i=0;i<chkObjs.length;i++){
             if(chkObjs[i].checked){
            	 delVal = chkObjs[i].value; 
             }
          } 
    	
    	 var orderSelect = document.getElementById(showOrder);
    	 var orderVal = orderSelect.options[index].value; 
    	 
    	 
    	 $.ajax({
 			url:"<%=basePath %>show/update",
 			data: 'showId=' + obj1+'&text='+text+'&delVal='+delVal+'&orderVal='+orderVal ,
 			dataType:"json",
 			type : "post",
 			success:function(data){
 				 window.location.reload();
 			},
 			error:function(result){
 				alert("网络错误");
 			},
 		});
     	}
    	 
    	
    	
    
    function delShow(obj){
    	$.ajax({
			url:"<%=basePath %>show/delShow",
			data: 'delid=' + obj ,
			dataType:"json",
			type : "post",
			success:function(data){
				window.location.href="<%=basePath %>show/init";
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
	<button type="button" class="btn btn-success" id="addnew">新增</button><br>
</form>
<%-- <table class="table table-bordered table-hover definewidth m10" >
    <thead>
    <tr>
        <th>序号</th>
        <th>图片</th>
        <th>产品名称</th>
        <th>产品分类</th>
        <th>操作</th>
    </tr>
    </thead>
	<c:forEach var="item" items="${menus}" varStatus="status">     
	     <tr>
            <td>${ status.index + 1}</td>
            <td><img alt="未上传图片" src=""></td>
            <td>${item.tLink}</td>
            <td>${item.tSort}</td>
            <td>
				<c:if test="${empty item.pname}">该菜单为一级菜单</c:if> 
				<c:if test="${not empty item.pname}">${item.pname}</c:if> 
			</td>
            <td>
                  <a href="javascript:void(0)" onclick="editMenu(${item.id})">编辑</a>
                  <a href="javascript:void(0)" onclick="delmenu(${item.id})" >删除</a>
                  
            </td>
        </tr>
        </c:forEach>

        </table> --%>
        
        <hr style="height:10px;border:none;border-top:10px groove skyblue;" />
        <c:forEach var="item" items="${shows}" varStatus="status">  
        	<ul style="list-style: none;border: solid 1px grey; width: 220px;height: 400px;padding: 5px;float: left;">
        		<li style="border-bottom:solid 1px grey; "><img alt="未上传图片" src="${item.showPicUrlPath }" style="width: 200px;height: 200px;margin-bottom: 5px"></li>
        		<li style="border-bottom:solid 1px grey; ">图片配文: <textarea rows="2" cols="8" readonly="readonly" id="showPicText${ status.index + 1}">${item.showPicText}</textarea> </li>
        		<li style="border-bottom:solid 1px grey; " id ="showDelContext${ status.index + 1}" >
        			是否可用: <c:if test="${item.showDel == 0 }">启用</c:if> 
        				   <c:if test="${item.showDel == 1 }">禁用</c:if> 
        		</li>
        		<li style="border-bottom:solid 1px grey;display: none " id ="showDelSelect${ status.index + 1}" >
        			<input type="radio" name="showDel${ status.index + 1}" value="0" /> 启用
		        	<input type="radio" name="showDel${ status.index + 1}" value="1" /> 禁用 
        		</li>
        		<li style="border-bottom:solid 1px grey;" id ="showOrderContext${ status.index + 1}" >
        			展示顺序：${item.showPicOrder}
        		</li>
        		<li style="border-bottom:solid 1px grey;display: none" id ="showOrderSelect${ status.index + 1}" >
        			展示顺序：<select id="showOrder${ status.index + 1}" style="width: 200px">
		        				<option value="1">1</option>
		        				<option value="2">2</option>
		        				<option value="3">3</option>
		        				<option value="4">4</option>
		        				<option value="5">5</option>
		        		  </select>
        		</li>
        	
        		<li>
        			<a href="javascript:void(0)" onclick="editShow(${ status.index + 1})" id="editBut${ status.index + 1}">编辑</a>
        			<button type="button" class="btn btn-success" onclick="saveShow(${item.showId},${status.index + 1})" style="display: none;float: left" id="saveBut${ status.index + 1}">保存</button>
        			<button type="button" class="btn btn-success" onclick="cancelShow(${status.index + 1})" style="display: none;float: left" id="cancelBut${ status.index + 1}">取消</button>|
                    <a href="javascript:void(0)" onclick="delShow(${item.showId})">删除</a>
        		</li>
        	</ul>
           
        </c:forEach>
        
</body>
</html>