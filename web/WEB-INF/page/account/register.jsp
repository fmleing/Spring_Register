<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/page/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/calendar.js"></script>
</head>
<body>
<fieldset><legend>用户注册</legend><form:form commandName="account">
    <ul>
        <li><form:label path="username">用户名:</form:label><form:input
                path="username" /></li>
        <li><form:label path="password">密码:</form:label><form:password
                path="password" /></li>
        <li><form:label path="birthday">生日:</form:label><form:input
                path="birthday" onfocus="showDate(this);" /></li>
        <li><form:label path="email">Email:</form:label><form:input
                path="email" /></li>
        <li>
            <button type="submit">注册</button>
            <button type="reset">重置</button>
        </li>
    </ul>
</form:form></fieldset>
</body>
</html>