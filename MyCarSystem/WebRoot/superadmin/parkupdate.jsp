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
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>停车场管理<span class="crumb-step">&gt;</span><span>修改停车场信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <s:form action="parkupdate" method="post" namespace="/"> 
                 <s:hidden name="parkUpdate.parkId" value="%{#session.park.parkId}"></s:hidden>
                    <table class="insert-tab" width="100%">
                        <tbody>
                        	<tr>
                          	  	<th width="120"><i class="require-red">*</i>停车场名称：</th>
                         	    <td><s:textfield name="parkUpdate.parkName" value="%{#session.park.parkName}"></s:textfield></td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>停车场车位数：</th>
                                <td><s:textfield name="parkUpdate.maxCarValue" value="%{#session.park.maxCarValue}"></s:textfield></td>
                            </tr>
                            <tr>
                                <th>停车场当前车辆数</th>
                                <td><s:textfield name="parkUpdate.carValue"  value="%{#session.park.carValue}" ></s:textfield></td>
                            </tr>
                            <tr>
                                <th>每小时价格</th>
                                <td><s:textfield name="parkUpdate.pricePreHour" value="%{#session.park.pricePreHour}"></s:textfield></td>
                            </tr>
                            <tr>
                                <th>过夜价格</th>
                                <td><s:textfield name="parkUpdate.priceDay" value="%{#session.park.priceDay}"></s:textfield></td>
                            </tr>

                            <tr>
                                <th></th>
                                <td>
                                	<sx:submit cssClass="btn btn-primary btn6 mr10" value="提交" targets="right"></sx:submit>
                                	<s:reset cssClass="btn btn6" onclick="history.go(-1)" value="重置"></s:reset> 
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </s:form>
            </div>
        </div>
</div>
</body>
</html>
