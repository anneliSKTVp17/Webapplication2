<%-- 
    Document   : showGreateHistori
    Created on : May 15, 2019, 6:52:00 PM
    Author     : user2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <h1>Создать историю</h1>
    </head>
    <body>
        <form action="createHistory" method="POST">
            Читатель<br>
            <select name="readerId"> 
             <c:forEach var="reader" items="${listReaders}">
                <option value="${reader.id}">${reader.name}</option> 
            </c:forEach>    
            </select><br>
            Книга<br>
            <select name="bookId"> 
                <c:forEach var="book" items="${listBooks}">
                <option value="${book.id}">${book.name}</option> 
            </c:forEach>  
            </select><br>
            <input type="submit" value="Выдать">
        </form>
    </body>
</html>