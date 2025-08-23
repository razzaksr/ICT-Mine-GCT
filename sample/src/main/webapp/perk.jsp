<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 22-08-2025
  Time: 06:25 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <jsp:useBean id="hi" class="help.User">--%>
<%--        <jsp:setProperty name="hi" property="password" value="razak"/>--%>
<%--        <jsp:setProperty name="hi" property="password" value="mohamed"/>--%>
<%--    </jsp:useBean>--%>
    <jsp:useBean id="hi" class="help.User">
        <jsp:setProperty name="hi" property="*"/>
    </jsp:useBean>
    <h1>${hi.username}</h1>
    <h1>${hi.password}</h1>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <ul>
        <c:choose>
            <c:when test="${not empty sessionScope.customers}">
                <c:forEach var="card" items="${sessionScope.customers}">
                    <li>${card.cardNumber}</li>
                    <ol>
                        <li>${card.cardHolder}</li>
                        <li>${card.cardBalance}</li>
                    </ol>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <li>No Cards available</li>
            </c:otherwise>
        </c:choose>
    </ul>
</body>
</html>
