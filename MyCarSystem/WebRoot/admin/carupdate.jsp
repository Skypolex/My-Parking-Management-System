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
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>车辆管理<span class="crumb-step">&gt;</span><span>修改车辆信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <s:form action="carupdate" method="post" namespace="/"> 
                <s:hidden name="carUpdate.carId" value="%{#session.car.carId}"></s:hidden>
			    <s:hidden name="carUpdate.admin.id" value="%{#session.loginAdmin.adminId}" ></s:hidden>
			    <s:hidden name="carUpdate.carInTime" value="%{#session.car.carInTime}" ></s:hidden>
                <s:hidden name="carUpdate.isMemberCar" value="%{#session.car.isMemberCar}" ></s:hidden>
                
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                          	  	<th width="120"><i class="require-red">*</i>车牌号：</th>
                         	    <td><s:textfield name="carUpdate.carNumber" value="%{#session.car.carNumber}" ></s:textfield></td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>停放停车场：</th>
                                <td><s:select value="%{#session.car.park.parkId}" name="carUpdate.park.parkId" listKey="parkId" listValue="parkName" list="%{#session.parkList}"></s:select></td>
                            </tr>
                            <tr>
                                <th>车辆信息描述</th>
                                <td><s:textfield name="carUpdate.carDescribe" value="%{#session.car.carDescribe}"></s:textfield></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                	<sx:submit cssClass="btn btn-primary btn6 mr10" value="提交" targets="right"></sx:submit>
                                	<s:reset cssClass="btn btn6" onclick="history.go(-1)" value="重置"></s:reset> 
                                </td>
                            </tr>
                        </tbody></table>
                </s:form>
            </div>
        </div>
</div>
</body>
</html>
