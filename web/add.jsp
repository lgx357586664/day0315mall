<%--
  Created by IntelliJ IDEA.
  User: Geng xing
  Date: 2019/3/15
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="ItemssServlet">
    <input type="hidden" name="method" value="add">
    <table>
        <tr>
            <td>商品名称</td>
            <td>
                <input type="text" name="name" >
            </td>
        </tr>
        <tr>
            <td>产地</td>
            <td>
                <input type="text" name="city" >
            </td>
        </tr>
        <tr>
            <td>单价</td>
            <td>
                <input type="text" name="price" >
            </td>
        </tr>
        <tr>
            <td>数量</td>
            <td>
                <input type="text" name="number" >
            </td>
        </tr>
        <tr>
            <td>图片</td>
            <td>
                <input type="text" name="picture" >
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
