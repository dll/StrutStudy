<%--
  Created by IntelliJ IDEA.
  User: Richard
  Date: 2017/6/21
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<H1>Register up for My Struts</H1>
<hr>
<form method="post" action="*reguser.action" id="PF">

    <p>请输入用户名：</p><br>
    <input type="text" name="username" id="name"><br>
    <br>
    <p>请输入密码：</p><br>
    <input type="password" name="password" id="key"><br>
    <p>请再次输入密码：</p><br>
    <input type="password" name="password" id="comkey"><br>
    <br>
    <input type="submit" value="注册" onclick="check()" >
    <s:actionmessage></s:actionmessage>
    <a href="login.jsp">登陆</a>

</form>
</body>
<script>
    function check() {
        var name=document.getElementById("name");
        var word=document.getElementById("key");
        var comword=document.getElementById("comkey");
        if(name==""||word==""||comword==""){
            alert("用户名和密码不能为空！");
            return false;
        }else {
            if(word!=comword){
                alert("两次输入的密码不相同！");
                return false;

            }else {
                return true;

            }

        }



    }
</script>

</html>
