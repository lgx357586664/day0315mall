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
    <title>查询商品</title>
</head>
<body>
<table border="1px" width="65%">
    <tr>
        <td>序号</td>
        <td>商品名称</td>
        <td>产地</td>
        <td>单价</td>
        <td>数量</td>
        <td>照片</td>
        <td>操作</td>
    </tr>

    <c:forEach var="map" items="${pageBean.list}" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${map.name}</td>
            <td>${map.city}</td>
            <td>${map.price}</td>
            <td>${map.number}</td>
            <td><img src="image/${map.picture}"width="100px" height="100px"title=${map.name}></td>
            <td>
                <a href="ItemssServlet?method=delete&id=${map.id}">delete</a>
                <a href="ItemssServlet?method=queryOne&id=${map.id}">update</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            <c:if test="${pageBean.pageIndex>1}">
                <a href="ItemssServlet?method=query&pageIndex=${pageBean.pageIndex-1}">上一页</a>
            </c:if>
            <c:choose>
                <c:when test="${pageBean.pages<=10}">
                    <c:set var="start" value="1"></c:set>
                    <c:set var="end" value="${pageBean.pages}"></c:set>
                </c:when>
                <c:otherwise>
                    <c:set var="start" value="${pageBean.pageIndex-5}"></c:set>
                    <c:set var="end" value="${pageBean.pageIndex+4}"></c:set>
                    <c:if test="${pageBean.pageIndex-5<1}">
                        <c:set var="start" value="1"></c:set>
                        <c:set var="end" value="10"></c:set>
                    </c:if>
                    <c:if test="${pageBean.pageIndex+4>pageBean.pages}">
                        <c:set var="start" value="${pageBean.pages-9}"></c:set>
                        <c:set var="end" value="${pageBean.pages}"></c:set>
                    </c:if>
                </c:otherwise>
            </c:choose>


            <c:forEach  var="i" begin="${start}" step="1" end="${end}">
                <c:if test="${pageBean.pageIndex==i}">
                    【${i}】
                </c:if>
                <c:if test="${pageBean.pageIndex!=i}">
                    <a href="ItemsServlet?method=query&pageIndex=${i}">【${i}】</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageBean.pageIndex<pageBean.pages}">
                <a href="ItemssServlet?method=query&pageIndex=${pageBean.pageIndex+1}">下一页</a>
            </c:if>
        </td>
    </tr>
</table>
<a href="add.jsp">add</a>
</body>
</html>
