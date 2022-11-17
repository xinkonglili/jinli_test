<%--
  Created by IntelliJ IDEA.
  User: czy
  Date: 2022-09-20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>延迟5秒跳转页面</title>
</head>
<body>
<h3>这里5秒后跳转至百度首页...</h3>
</body>
</html>

<script>
setTimeout(function (){
    location.href="http://www.baidu.com"
},5000)
</script>
