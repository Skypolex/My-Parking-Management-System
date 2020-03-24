<%@ page language="java" import="java.util.*,java.io.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
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

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="superadmin/superadmin.jsp">首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
        	
            <ul class="top-info-list clearfix">
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="superadmin/superadmin.jsp"><i class="icon-font">&#xe003;</i>管理操作</a>
                    <ul class="sub-menu">
                        <li><sx:a href="adminshow" targets="right"><i class="icon-font" >&#xe008;</i>停车场管理员管理</sx:a></li>
                        <li><sx:a href="carshow" targets="right"><i class="icon-font" >&#xe052;</i>车辆管理</sx:a></li>
                        <li><sx:a href="membercarshow" targets="right"><i class="icon-font" >&#xe005;</i>成员车辆管理</sx:a></li>
                        <li><sx:a href="parkshow" targets="right"><i class="icon-font" >&#xe006;</i>停车场管理</sx:a></li>
                        <!-- <li><a href="design.html"><i class="icon-font" >&#xe004;</i>公告管理</a></li> -->
                    </ul>
                </li>
                <li>
                    <a href="superadmin/superadmin.jsp"><i class="icon-font">&#xe018;</i>系统操作</a>
                    <ul class="sub-menu">
                        <li><a href="superadmin/superadmin.jsp"><i class="icon-font">&#xe017;</i>系统信息</a></li>
                        <li><sx:a href="parkinfo.jsp" targets="right"><i class="icon-font">&#xe046;</i>停车场综合信息</sx:a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap" id="right">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用『青空』停车场管理系统。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <sx:a href="carshow" targets="right"><i class="icon-font">&#xe001;</i>车辆管理</sx:a>
                    <sx:a href="adminshow" targets="right"><i class="icon-font">&#xe005;</i>停车场管理员管理</sx:a>
                    <sx:a href="membercarshow" targets="right"><i class="icon-font">&#xe048;</i>成员车辆管理</sx:a>
                    <sx:a href="parkshow" targets="right"><i class="icon-font">&#xe041;</i>停车场管理</sx:a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">客户端IP</label><span class="res-info"><%= request.getRemoteAddr() %></span>
                    </li>
                    <li>
                        <label class="res-lab">客户端端口</label><span class="res-info"><%= request.getRemotePort() %> </span>
                    </li>
                    <li>
                        <label class="res-lab">JSP运行方式</label><span class="res-info">Tomcat</span>
                    </li>
                    <li>
                        <label class="res-lab">后台版本</label><span class="res-info">v1.3</span>
                    </li>
                    <li>
                    	<%
							  Date date = new Date();
							  SimpleDateFormat sft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
						%>
                        <label class="res-lab">系统时间</label><span class="res-info"> <%= sft.format(date) %> </span>
                    </li>
                    <li>
                        <label class="res-lab">服务器IP</label><span class="res-info"><%= request.getLocalAddr() %></span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名</label><span class="res-info"><%= request.getServerName() %></span>
                    </li>
                    <li>
                        <label class="res-lab">服务器端口</label><span class="res-info"><%= request.getServerPort() %></span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">开发者网站：</label><span class="res-info"><a href="http://www.mysora.cn/" target="_blank">我的天空</a></span>
                    </li>
                    <li>
                        <label class="res-lab">客户交流群：</label><span class="res-info"><a class="qq-link" target="_blank" href="http://shang.qq.com/wpa/qunwpa?idkey=e917fda230767914cb8c8bca911eb4833fb7268756949cbe2392864878164e3b"><img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="天空湛蓝" title="天空湛蓝"></a> </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>