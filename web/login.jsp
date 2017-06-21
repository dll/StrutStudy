<%--
  Created by IntelliJ IDEA.
  User: Richard
  Date: 2017/6/21
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login For My Struts</h1>
<hr>
<div>
    <form method="post" action="loginuser.action" id="PF">

            <p>用户名：</p><br>
            <input type="text" name="username" id="name"><br>
            <br>
            <p>密码：</p><br>
            <input type="password" name="password" id="key"><br>
            <br>
            <s:actionmessage></s:actionmessage>
            <input type="submit" value="登陆" onclick="check()">

            <a href="register.jsp">点我注册</a>

    </form>

</div>


</body>
<script>
    function check() {
        var name=document.getElementById("name");
        var word=document.getElementById("key");
        if(name==null||name==""||word==null||word==""){
            alert("用户名和密码不能为空！");
            return false;
        }else {
            return true;
        }

    }
</script>

</html>
