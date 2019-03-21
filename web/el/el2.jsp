<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 2019/3/20
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域中el取值</title>
</head>
<body>
    <%
        /*在域中取值从小到大*/
        pageContext.setAttribute("name","xieliu");
        request.setAttribute("name","zhangsan");
        session.setAttribute("name","lisi");
        application.setAttribute("name","wangwu");
    %>
        ${name}
</body>
</html>
