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
            <div class="crumb-list"><i class="icon-font"></i>首页<span class="crumb-step">&gt;</span>管理员管理<span class="crumb-step">&gt;</span><span>更新管理员信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <s:form action="adminupdate" method="post" namespace="/"> 
                <s:hidden name="adminUpdate.adminId" value="%{#session.admin.adminId}"></s:hidden>
                    <table class="insert-tab" width="100%">
                        <tbody>
							<tr>
                          	  	<th width="120"><i class="require-red">*</i>用户名：</th>
                         	    <td><s:textfield name="adminUpdate.adminName" value="%{#session.admin.adminName}"> </s:textfield></td>
                        	</tr>
                            <tr>
                                <th><i class="require-red">*</i>密码：</th>
                                <td><s:textfield name="adminUpdate.adminPassword" value="%{#session.admin.adminPassword}"></s:textfield></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>是否为超级管理员(0或1)</th>
                                <td><s:textfield name="adminUpdate.isSuperAdmin" value="%{#session.admin.isSuperAdmin}"></s:textfield></td>
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
                        	