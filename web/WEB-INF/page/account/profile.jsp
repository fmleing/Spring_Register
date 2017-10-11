<%--
  Created by IntelliJ IDEA.
  User: Tomecs
  Date: 2017/10/10
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/page/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset><legend>用户信息</legend>
    <ul>
        <li><label>用户名:</label><c:out value="${account.username}" /></li>
        <li><label>生日：</label><fmt:formatDate value="${account.birthday}" pattern="yyyy年MM月dd日"/> </li>
        <li><label>邮箱：</label><c:out value="${account.email}"/></li>
    </ul>
</fieldset>
</body>
</html>
