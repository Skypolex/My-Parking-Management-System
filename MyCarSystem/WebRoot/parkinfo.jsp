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
            <div class="crumb-list"><i class="icon-font"></i>停车场综合信息</div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-content">
                    <table class="result-tab" width="100%">
                    
                        <tr>
                            <th>停车场名称</th>
                            <th>停车场车位数</th>
                            <th>停车场当前车辆数</th>
                            <th>每小时价格</th>
                            <th>过夜价格</th>
                            <th>剩余车位</th>
                        </tr>
                        
                        <s:iterator value="%{#session.parkList}" var = "park">
						<tr>
						   <td><s:property value="#park.parkName"/></td>
						   <td><s:property value="#park.maxCarValue"/></td>
						   <td><s:property value="#park.carValue"/></td>
						   <td><s:property value="#park.pricePreHour"/></td>
						   <td><s:property value="#park.priceDay"/></td>
						   <td><s:property value="#park.maxCarValue - #park.carValue"/></td>
						</tr>
				   		</s:iterator>

                    </table>
                    <div class="list-page">青空停车场管理系统</div>
                    <div class="list-page"><a href="login.jsp">&nbsp;&nbsp;&nbsp;--进入后台管理--&nbsp;&nbsp;&nbsp;</a></div>
                </div>
            </form>
        </div>
</div>
</body>

</html>
