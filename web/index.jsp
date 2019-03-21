<%--
  Created by IntelliJ IDEA.
  User: HI
  Date: 2019/3/19
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
    <script>
      function changeImg() {
        var img=document.getElementById("img");
        img.src="/demo/checkCodeServlet?"+new Date().getTime();
      }
    </script>
  </head>
  <body>
  //点击图片换验证码
  <img src="/demo/checkCodeServlet" id="img" onclick="changeImg()"/>
  <a href="javascript:changeImg()">看不清？换一张</a>
  </body>
</html>
