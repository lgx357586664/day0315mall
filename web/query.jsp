<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/15
  Time: 0:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询</title>
</head>
<body>
<table border="1px" >
    <tr>
        <td>id</td>
        <td>name</td>
        <td>city</td>
        <td>price</td>
        <td>number</td>
        <td>picture</td>
        <td>action</td>
    </tr>

    <c:forEach var="map" items="${all}">
        <tr>
            <td>${map.id}</td>
            <td>${map.name}</td>
            <td>${map.city}</td>
            <td>${map.price}</td>
            <td>${map.number}</td>
            <td>${map.picture}</td>
            <td>
                <a href="ItemssServlet?method=delete&id=${map.id}">delete</a>
                <a href="ItemssServlet?method=queryOne&id=${map.id}">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="add.jsp">add</a>
</body>
</html>
