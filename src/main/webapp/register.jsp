<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/19
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="index.html" method="post">
        username:<input type="text" name="username" id="username" onblur="checkUser()"><font color="red"><span id="msg"></span></font><p />
        password:<input type="text" name="password"><p />
        age:<input type="text" name="age"><p />
        tel:<input type="text" name="tel"><p />
        addr:<input type="text" name="addr"><P/>
        <input type="submit" value="submit"><p/>
    </form>
    
    <script>
        function checkUser() {

            var username = document.getElementById("username").value.trim();

            var xhr;

            //  1.创建XMLHttpRequest对象
            if (window.XMLHttpRequest) {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xhr = new XMLHttpRequest();
            }else {
                // IE6, IE5 浏览器执行代码
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }

            // 2.设置回调事件
            xhr.onreadystatechange = function () {
                if(xhr.readyState == 4 && xhr.status == 200){

                    if(xhr.responseText == "exist"){
                        document.getElementById("msg").innerText = "the user is already exists";
                    }else{
                        document.getElementById("msg").innerText = "the user is already no exist";
                    }
                }
            }

            // 3.发送链接
            xhr.open("GET","checkUserServlet?username="+username,true);

            //4,异步发送
            xhr.send();

        }
    </script>
</body>
</html>
