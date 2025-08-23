<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 23-08-2025
  Time: 05:30 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve Card</title>
</head>
<body>
    <form action="cards/create" method="post" enctype="multipart/form-data">
        <input type="text" name="cardHolder"/>
        <input type="text" name="cardNumber"/>
        <input type="text" name="cardBalance"/>
        <input type="file" name="pan" />
        <input type="submit" value="Approve"/>
    </form>
</body>
</html>
