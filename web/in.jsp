<%--
  Created by IntelliJ IDEA.
  User: Richard
  Date: 2017/6/16
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>WelCome to My Struts Page</h1>
<hr>
当前登录的用户:${param.username}<br>
<hr>
当前所有登陆的用户：
<s:iterator value="#application.online" var="user">
   <s:property value="#user"></s:property>
</s:iterator>
<a href="login.jsp">注销</a>
</body>
</html>
