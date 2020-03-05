<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/5
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>年级编号</td>
        <td>年级</td>
    </tr>
<c:forEach items="${pageInfo.list}" var="l">
    <tr>
        <td>${l.gid}</td>
        <td>${l.gname}</td>
    </tr>
</c:forEach>
</table>
<div>
    <div>
        当前第${pageInfo.pageNum}页，共${pageInfo.pages}页，每页${pageInfo.pageSize}行。
    </div>
    <div>
        <a href="/gread?page=1">首页</a>
        <a href="/gread?page=${pageInfo.prePage==0?1:pageInfo.prePage}">上一页</a>
        <a href="/gread?page=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}">下一页</a>
        <a href="/gread?page=${pageInfo.pages}">尾页</a>
    </div>
</div>
</body>
</html>
