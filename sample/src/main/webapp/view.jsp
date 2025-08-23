<%--
  Created by IntelliJ IDEA.
  User: SRDB
  Date: 23-08-2025
  Time: 05:33 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Cards</title>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <h1>Cards are</h1>
    <table cellspacing="1px" cellpadding="1px">
        <thead>
        <tr>
            <th>Card Number</th><th>Card Holder</th><th>Card Balance</th><th>PAN</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty sessionScope.customers}">
                <c:forEach var="card" items="${sessionScope.customers}">
                    <tr>
                        <td>${card.cardNumber}</td>
                        <td>${card.cardHolder}</td>
                        <td>${card.cardBalance}</td>
                        <td>${card.pan}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="4">No card data available</td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</body>
</html>
