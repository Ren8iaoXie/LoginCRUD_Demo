<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 2019/3/20
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%--\代表转义字符--%>
    \${3+4}<br>
    虚拟路径: ${pageContext.request.contextPath} <br>
    3 除以 2${3 div 2 }
</body>
</html>
