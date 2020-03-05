<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/2
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script language="JavaScript" type="text/javascript" src="static/js/jquery-1.9.1.min.js"></script>
    <script>
        function go(page) {

            $("#inin").val(page);
            $("#form1").submit();
        }
    </script>
</head>
<body>
<a href="/login1">查询所有</a>
<a href="/login6">添加</a>

<form id="form1" name="form1" method="post" action="/login9">
    <input type="hidden" name="page" id="inin" value="1">
    姓名：
    <input type="text" name="name" id="textfield" value="${fenye.name}"/>
    最大年龄：
    <input type="text" name="endage" id="textfield2"value="${fenye.endage}"/>
    -最小年龄：
    <input type="text" name="aage" id="textfield3" value="${fenye.aage}"/>
    <input type="submit" name="button" id="button" value="查询" />
</form>
<table border="1px">
    <tr>
        <td>学号</td>
        <td>名字</td>
        <td>性别</td>
        <td>生日</td>
        <td>年龄</td>
        <td>电话</td>
        <td>gid</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="l">
        <tr>
            <td>${l.xh}</td>
            <td>${l.name}</td>
            <td>${l.sex}</td>
            <td><fmt:formatDate value="${l.birthday}" pattern="yyyy-MM-dd"/> </td>
            <td>${l.age}</td>
            <td>${l.tel}</td>
            <td>${l.gid}</td>
            <td>${l.dz}</td>
            <td>
                <a href="/login4?id=${l.xh}">修改</a>
                <a href="javascript:if(confirm('是否删除')){location.href='/login3?id=${l.xh}'}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <div>当前第${pageInfo.pageNum}页，共${pageInfo.pages}页，没页${pageInfo.pageSize}行。</div>
    <div>
        <a href="javascript:go(1)">首页</a>
        <a href="javascript:go(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</a>
        <a href="javascript:go(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</a>
        <a href="javascript:go(${pageInfo.pages})">尾页</a>
    </div>
</div>

</body>
</html>
