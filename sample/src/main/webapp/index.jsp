<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Page</title>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="health" uri="/WEB-INF/health.tld" %>
    <health:bmr gender="male" height="175" weight="70"  age="30"/>
    <health:bmr gender="female" height="160" weight="55" age="25" />

    <a href="approve.jsp">New Card</a>
    <h1><%out.println(request.getCookies()[0].getValue());  %></h1>
    <table cellspacing="1px" cellpadding="1px">
        <thead>
        <tr>
            <th>Card Number</th><th>Card Holder</th><th>Card Balance</th>
        </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty sessionScope.customers}">
                    <c:forEach var="card" items="${sessionScope.customers}">
                        <tr>
                            <td>${card.cardNumber}</td>
                            <td>${card.cardHolder}</td>
                            <td>
                                <fmt:formatNumber value="${card.cardBalance}" pattern="#,##0.00" />
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="3">No card data available</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>
    <%--    what if session invalidate so that in next page you cant see customers as ul--%>
    <% session.removeAttribute("customers"); %>
    <form action="perk.jsp" method="post">
        <input type="text" name="username"/>
        <input type="password" name="password"/>
        <input type="submit" />
    </form>
</body>
</html>