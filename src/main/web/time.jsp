<%--
  Created by IntelliJ IDEA.
  User: wllwo
  Date: 2022/11/16
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>倒计时</title>
</head>

<body>
<input type="button" id="btn" value="倒计时" onclick="setTime(this)">
<script type="text/javascript">
    var countTime = 5;
    function setTime(val){
        if (countTime!=0){
            val.setAttribute("disable",true);
            val.value = "时间倒计时("+ countTime+")"
            countTime--;
        }else{
            val.removeAttribute("disabled")
            val.value="倒计时"
            countTime = 5
            return;
        }
        setTimeout(function(){
            setTime(val)
        },1000)
    }

</script>
</body>
</html>
