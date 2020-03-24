<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@taglib uri="/struts-tags" prefix="s" %>

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
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>车辆管理<span class="crumb-step">&gt;</span><span>车辆停车信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                          	  	<th width="120">车牌号：</th>
                         	    <td><s:property value="%{#session.car.carNumber}"/></td>
                        	</tr>
                            <tr>
                                <th>停放停车场:</th>
                                <td><s:property value="%{#session.car.park.parkName}"/></td>
                            </tr>
                            <tr>
                                <th>进入时间:</th>
                                <td><s:date name="%{#session.car.carInTime}" format="yyyy-MM-dd HH:mm:ss"/></td>
                            </tr>
                            <tr>
                                <th>是否为成员车辆:</th>
                                <td><s:property value="%{#session.car.isMemberCar}"/></td>
                            </tr>
                            <tr>
                                <th>车辆信息描述:</th>
                                <td><s:property value="%{#session.car.carDescribe}"/></td>
                            </tr>
                            <tr>
                                <th>操作员:</th>
                                <td><s:property value="%{#session.car.admin.adminName}"/></td>
                            </tr>
                            <tr>
                                <th>停车时间:</th>
                                <td><s:property value="%{#session.carParkingTime}"/></td>
                            </tr>
                            <tr>
                                <th>停车费用:</th>
                                <td><s:property value="%{#session.carParkingFee}"/></td>
                            </tr>
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                	<sx:a cssClass="btn btn-primary btn6 mr10"  href="cardelete?carId=%{#session.car.carId}" targets="right" >车辆离开 </sx:a>
                                </td>
                            </tr>
                        </tbody></table>
            </div>
        </div>
</div>
</body>
</html>
