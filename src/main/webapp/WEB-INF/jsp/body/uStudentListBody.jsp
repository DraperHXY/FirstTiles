<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2018/11/6
  Time: 上午9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td></td>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td> ${student}</td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
