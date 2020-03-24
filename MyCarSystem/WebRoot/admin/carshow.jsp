<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <sx:head/>
	<meta charset="UTF-8">	
    <title>青空停车场管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="青空,停车场,管理系统,停车场管理系统">
	<meta http-equiv="description" content="青空停车场管理系统">
	
</head>
<body>
<div class="container clearfix">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span><span class="crumb-name">车辆管理</span></div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <sx:a href="carinput" targets="right"><i class="icon-font"></i>新增车辆</sx:a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                    
                        <tr>
                            <th>车辆ID</th>
                            <th>车牌号</th>
                            <th>停放停车场</th>
                            <th>进入时间</th>
                            <th>是否为成员车辆</th>
                            <th>车辆信息描述</th>
                            <th>操作员</th>
                            <th>操作</th>
                        </tr>
                        
                        <s:iterator value="%{#session.carList}" var = "car">
						<tr>
						   <td><s:property value="#car.carId"/></td>
						   <td><s:property value="#car.carNumber"/></td>
						   <td><s:property value="#car.park.parkName"/></td>
						   <td><s:date name="#car.carInTime" format="yyyy-MM-dd HH:mm:ss"/></td>
						   <td><s:property value="#car.isMemberCar"/></td>
						   <td><s:property value="#car.carDescribe"/></td>
						   <td><s:property value="#car.admin.adminName"/></td>
						   <td>
							   <sx:a href="cardelete?carId=%{#car.carId}" targets="right" >车辆离开（删除）</sx:a>
							   &nbsp;&nbsp;&nbsp;
							   <sx:a href="carcheck?carId=%{#car.carId}" targets="right" >查看停车信息 </sx:a>
						   </td>
						</tr>
				   		</s:iterator>

                    </table>
                    <div class="list-page"> --青空停车场管理系统-- </div>
                </div>
            </form>
        </div>
</div>
</body>

</html>
