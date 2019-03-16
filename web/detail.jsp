<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/16
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<table border="1px" width="65%">
    <tr>
        <td>商品名称</td>
        <td>产地</td>
        <td>单价</td>
        <td>数量</td>
        <td>图片</td>
        <td>操作</td>
    </tr>

    <tr>
        <td>${items.name}</td>
        <td>${items.city}</td>
        <td>${items.price}</td>
        <td>${items.number}</td>
        <td><img src="image/${items.picture}" width="100px" height="100px" title="${items.name}" ></td>
        <td><a href="ItemsServlet?method=car&id=${items.id}">加入购物车</a></td>
    </tr>
</table>

</body>
</html>
