<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/5
  Time: 8:14
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
显示：
<dl>
    <c:forEach items="${grades}" var="g" varStatus="sta">
        <dt>${g.gname}</dt>
            <dd>学生</dd>
            <c:forEach items="${list}" var="l">
                <dd>${l.xh}</dd>
                <dd>${l.name}</dd>
                <dd>${l.sex}</dd>
                <dd><fmt:formatDate value="${l.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate> </dd>
                <dd>${l.age}</dd>
                <dd>${l.dz}</dd>
            </c:forEach>
    </c:forEach>
</dl>
</body>
</html>
