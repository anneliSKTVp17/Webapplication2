<%-- 
    Document   : showAddReader
    Created on : May 10, 2019, 7:18:03 PM
    Author     : user2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить читателей</title>
    </head>
    <body>
        <h1>Имя читателя</h1>
   <form action="createReader" method="POST">
            Имя читателя:<br>
            <input type="text" name="name"><br>
            Фамилия читателя:<br>
            <input type="text" name="lastname"><br>
            Телефон:<br>
            <input type="text" name="phone"><br>
            <input type="submit" value="Создать">
        </form>
    </body>
</html>