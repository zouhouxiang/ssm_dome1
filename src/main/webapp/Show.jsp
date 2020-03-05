<%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2020/1/2
  Time: 19:02
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

<form id="form1" name="form1" method="post" action="/login2">
    <input type="hidden" id="aaa" value="1">
    <p>卡种：
        <select name="select" id="select">
            <option value="">请选择</option>
            <c:forEach items="${grades}" var="g">
                <option ${param.select==g.gid?"selected":""} value="${g.gid}">${g.gname}</option>
            </c:forEach>
        </select>
        地址：
        <input type="text" name="textfield" id="textfield" value="${param.textfield}"/>
        <input type="submit" name="button" id="button" value="提交" />
    </p>
</form>
<table width="100%" border="1">
    <tr>
        <td>学号</td>
        <td>名字</td>
        <td>性别</td>
        <td>生日</td>
        <td>年龄</td>
        <td>电话</td>
        <td>年级</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.xh}</td>
            <td>${l.name}</td>
            <td>${l.sex}</td>
            <td><fmt:formatDate value="${l.birthday}" pattern="yyyy-MM-dd"/> </td>
            <td>${l.age}</td>
            <td>${l.tel}</td>
            <td>${l.gname}</td>
            <td>${l.dz}</td>
            <td>删除 修改</td>
        </tr>
    </c:forEach>
</table>
当前第${p}页,每页${pagesize}行，共多少页。
<a href="javascript:go(1)">首页</a>
<a href="javascript:go(${(p-1)==0?1:(p-1)})">上一页</a>

<input type="text" name="gofi" id="gofi" value=""/>
<input type="submit" name="button1" id="button1" onclick="go(this.previousElementSibling.value)" value="Go" />

<a href="javascript:go(${p+1>hang?hang:(p+1)})">下一页</a>
<a href="javascript:go(${hang})">尾页</a>

<script language="JavaScript" src="js/jquery-1.9.1.min.js"></script>
<script language="JavaScript">
    function go(pag) {
        document.getElementById("aaa").value=pag;
        document.getElementById("form1").submit();

    }

</script>
</body>
</html>
