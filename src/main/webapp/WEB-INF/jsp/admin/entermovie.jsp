<%-- 
    Document   : entermovie
    Created on : Nov 20, 2018, 5:08:45 PM
    Author     : benjo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter a new movie</title>
    </head>
    <%@include file="menu.jsp"%>
    <body>
        <h1>Insert movie details:</h1>
        <form action="entermovie" method="post" enctype="multipart/form-data">
            Title: <input type="text" name="title"/><br>
            <br>
            Price: <input type="number" name="price" /><br>
            <br>
            Supers: <input type="number" name="supersaver" /><br>
            <br>
            Avail: <input type="number" name="availability" /><br>
            <br>
            Photo: <input type="file" name="photo" /><br>
            <br>
            <select name="category">
                <option value="-1"> Select category:</option>
                <c:forEach items="${categories}" var="category">
                    <option <c:if test="${category.id == selectedCategory.id}"> selected </c:if>value="${category.id}">${category.name}</option>
                </c:forEach>
            </select><br>
            <br>
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
