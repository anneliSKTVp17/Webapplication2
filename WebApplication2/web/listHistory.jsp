<%-- 
    Document   : listBooks
    Created on : May 9, 2019, 7:20:52 PM
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выданные книги</title>
    </head>
    <body>
        <h1>Выданные книги</h1>
        <c:forEach var="history" items="${listHistory}">
            <p>${history}</p>
        </c:forEach>
    </body>
</html>