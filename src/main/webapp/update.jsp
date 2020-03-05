<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/3
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="/login5">
    <input type="hidden" name="xh" value="${students.xh}">
    <p>姓名：
        <input type="text" name="name" id="textfield" value="${students.name}" />
    </p>
    <p>性别：
        <input ${students.sex=="男"?"checked":""} type="radio" name="sex" value="男"/>男
        <input ${students.sex=="女"?"checked":""} type="radio" name="sex"  value="女" />女
    </p>
    <p>年龄：
        <input type="text" name="age" id="textfield3" value="${students.age}" />
    </p>
    <p>生日:
        <input type="date" name="birthday" id="textfield000" value='<fmt:formatDate value="${students.birthday}" pattern="yyyy-MM-dd"/>' />
    </p>
    <p>电话：
        <input type="text" name="tel" id="textfield4" value="${students.tel}" />
    </p>
    <p>年级：
        <select name="gid" id="select">
            <c:forEach items="${grades}" var="g">
                <option ${param.select==g.gid?"selected":""} value="${g.gid}">${g.gname}</option>
            </c:forEach>
        </select>
    </p>
    <p>地址：
        <input type="text" name="dz" id="textfield5" value="${students.dz}" />
    </p>
    <p>
        <input type="submit" name="button" id="button" value="修改" />
    </p>
</form>
</body>
</html>
