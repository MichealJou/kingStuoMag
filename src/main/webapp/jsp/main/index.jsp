<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/jsp/assets/img/logo.png" />
 <link href="<%=basePath %>jsp/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
 <link href="<%=basePath %>jsp/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
 <link href="<%=basePath %>jsp/assets/css/main-min.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="<%=basePath %>jsp/assets/js/jquery-1.8.1.min.js"></script>
 <script type="text/javascript" src="<%=basePath %>jsp/assets/js/bui-min.js"></script>
 <script type="text/javascript" src="<%=basePath %>jsp/assets/js/common/main-min.js"></script>
 <script type="text/javascript" src="<%=basePath %>jsp/assets/js/config-min.js"></script>
<title>后台管理系统</title>
<script>
    BUI.use('common/main',function(){
        var config = [
                      {id:'1',homePage:'<%=basePath %>jsp/login/homePage.jsp',menu:[{text:'首页信息',
                    	  items:[{id:'2',text:'首页菜单管理',href:'<%=basePath %>menu/init'},
                    	         {id:'3',text:'首页图文管理',href:'<%=basePath %>show/init'},
                    	       ]
                      }]},
                      {id:'4',menu:[{text:'公司简介',
                    	  items:[{id:'5',text:'公司简介管理',href:'<%=basePath %>introduction/editInit'}]
                      }]},
                      {id:'6',menu:[{text:'产品信息',
                    	  items:[
                    	         {id:'8',text:'产品信息管理',href:'<%=basePath %>product/init'},
                    	  ]
                      }]},
                      {id:'9',menu:[{text:'文章信息',
                    	  items:[{id:'10',text:'公司动态管理',href:'<%=basePath %>article/init?typeId=0'},
                    	         {id:'11',text:'行业新闻管理',href:'<%=basePath %>article/init?typeId=1'},
                    	         {id:'12',text:'招聘信息管理',href:'<%=basePath %>article/init?typeId=2'},
                    	  ]
                      }]},
                      {id:'13',menu:[{text:'联系方式',
                    	  items:[{id:'14',text:'联系方式管理',href:'<%=basePath %>cantact/editInit'}
                    	  ]
                      }]},
                      
                     
                      ]; 
                      
    
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</head>
<body>
<input type="hidden" value="${menuarr}" readonly="readonly">

	<div class="header">
	    <div class="dl-title" >
	        	 <img src="<%=basePath %>jsp/assets/img/top.jpg" style="height: 35px"> 
	        	<!--  <font style="size: ;color: #c1d5ec;font-family: Microsoft YaHei">凯旋思扩管理系统</font> -->
	    </div>
	    <div class="dl-log">
	    	欢迎您，<span class="dl-log-user">${sessionScope.user.username}</span><a href="<%=basePath %>login/loginout" title="退出系统" class="dl-log-quit">[退出]</a>
	    </div>
	</div>

	<div class="content" style="background-color: red">
	    <div class="dl-main-nav">
	        <div class="dl-inform"><div class="dl-inform-title"></div></div>
	        <ul id="J_Nav"  class="nav-list ks-clear">
	        
	        
	   
	            <li class="nav-item dl-selected">
	            	<div class="nav-item-inner nav-home">首页信息</div>
	            </li>
	            <li class="nav-item dl-selected">
	            	<div class="nav-item-inner nav-order">公司简介</div>
	            </li>
	            <li class="nav-item dl-selected">
	            	<div class="nav-item-inner nav-order">产品信息</div>
	            </li>
	            <li class="nav-item dl-selected">
	            	<div class="nav-item-inner nav-order">文章信息</div>
	            </li>
	            <li class="nav-item dl-selected" >
	            	<div class="nav-item-inner nav-order">联系方式</div>
	            </li> 
	            
	           <%--  <c:forEach var="item" items="${menus}" varStatus="status">     
		             <li class="nav-item dl-selected">
		            	<div class="nav-item-inner nav-order">${item.menuText}</div>
		            </li>
	            </c:forEach> --%>
	            
	
	        </ul>
	    </div>
	    <ul id="J_NavContent" class="dl-tab-conten" >
	    	<!-- <li class="dl-tab-item">
	    		<div class="dl-inner-tab">
	    			<div class="bui-nav-tab" aria-disable="false" style="height:700" aria-pressed="false">
	    				<div class="tab-content-container" style="height:679">
	    					sssss
	    				</div>
	    			</div>
	    		</div>
	    	</li> -->
	    </ul>
	</div>

</body>
</html>