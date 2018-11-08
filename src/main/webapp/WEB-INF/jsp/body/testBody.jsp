<%--
  Created by IntelliJ IDEA.
  User: draper
  Date: 2018/11/7
  Time: 下午8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<div>

    <form action="/FirstTiles/test" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        delete account<input type="text" name="account"><br>
        <input type="submit" value="DELETE">
    </form>

</div>