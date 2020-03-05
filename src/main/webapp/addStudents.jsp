<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2019/12/28
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="/login7">
    <p>学号:
        <input type="text" name="xh" id="textfield" />
    </p>
    <p>姓名:
        <input type="text" name="name" id="textfield2" />
    </p>
    <p>性别:
        <input checked type="radio" name="sex" value="男"/>男
        <input type="radio" name="sex"  value="女" />女
    </p>
    <p>年龄:
        <input type="text" name="age" id="textfield4" />
    </p>
    <p>生日:
        <input type="date" name="birthday" id="textfield5" />
    </p>
    <p>地址:
        <input type="text" name="dz" id="textfield6" />
    </p>

    <p>年级:
        <select name="gid">
            <c:forEach items="${grades}" var="g">
                <option value="${g.gid}">${g.gname}</option>
            </c:forEach>
        </select>
        <input type="submit" name="button" id="button" value="提交" />
    </p>
</form>
</body>
</html>
