<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html class="no-js">
    <head>
    	<base href="<%=basePath%>">
    	<meta charset="UTF-8">
        <title>青空停车管理系统</title>
        <meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="青空,停车场,管理系统,停车场管理系统">
		<meta http-equiv="description" content="青空停车场管理系统">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="青空停车场管理系统">
        <meta name="author" content="xarox">

        <!-- CSS -->
        
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>青空停车管理系统</h1>
            <form action="login" method="post" >
                <input type="text" name="adminName" class="username" placeholder="管理员名称">
                <input type="password" name="password" class="password" placeholder="密码">
                <button type="submit">登&nbsp;录</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p><s:actionerror/></p>
                <p>
                
                </p>
            </div>
        </div>
        <div align="center">联系我们 <a href="http://www.mysora.cn/" target="_blank" title="青空停车管理系统">青空停车管理系统</a></div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>

