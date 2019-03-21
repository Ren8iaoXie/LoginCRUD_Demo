<%@ page import="entry.User" %><%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 2019/3/20
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        User user=new User();
        user.setName("张三");
        user.setAge(40);
        request.setAttribute("user",user);
    %>
${requestScope.user.name}
${requestScope.user.age}
</body>
</html>
