<%--
  Created by IntelliJ IDEA.
  User: Tomecs
  Date: 2017/10/10
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/taglibs.jsp"%>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<fieldset><legend>登录</legend><form:form commandName="account">
    <form:hidden path="id" />
    <ul>
        <li><form:label path="username">用户名:</form:label><form:input
                path="username" /></li>
        <li><form:label path="password">密码:</form:label><form:password
                path="password" /></li>
        <li>
            <button type="submit">登录</button>
            <button onclick="window.location.href='register.do';">注册</button>
        </li>
    </ul>
</form:form></fieldset>
</body>
</html>
