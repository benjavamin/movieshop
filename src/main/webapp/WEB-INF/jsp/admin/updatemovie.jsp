<%-- 
    Document   : updatemovie
    Created on : Nov 15, 2018, 6:04:27 PM
    Author     : benjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <form method="post" action="updatemovie" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${movie.id}"/>
            Title: <input type="text" name = "title" value = "${movie.title}"/><br>
            Price: <input type="number" name = "price" value = "${movie.price}"/><br>
            <select name="category">
                <c:forEach items="${categories}" var="category">
                    <option <c:if test="${category.id == movie.category}">selected</c:if>value="${category.id}">${category.name}</option>
                </c:forEach>
            </select><br>
            <input type="file" name = "photo" />
            <input type="submit" name="update" value="Update Movie"/>
            <br>
        </form>
    </body>
</html>
