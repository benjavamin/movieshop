<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online Movie Store</title>
<base href="/movieshop/"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrapper">
  <div id="inner">
    <div id="header">
      <h1><img src="resources/images/logo.gif" width="519" height="63" alt="Online Movie Store" /></h1>
      <div id="nav"> <a href="../movieshop">HOME</a> | <a href="cart">view cart</a> | <a href="#">help</a> </div>
      <!-- end nav -->
      <a href="#"><img src="resources/images/header_1.jpg" width="744" height="145" alt="Harry Potter cd" /></a> <a href="#"><img src="resources/images/header_2.jpg" width="745" height="48" alt="" /></a> </div>
    <!-- end header -->
    <dl id="browse">
      <dt>Full Category Lists</dt>
      <c:forEach items="${categories}" var="category">
          <dd><a href="./${category.id}">${category.name}</a></dd>
      </c:forEach>
      <dt>Search Your Favourite Movie</dt>
      <dd class="searchform">
          <form action="search" method="GET">
          <div>
            <select name="category">
              <option value="-1" selected="selected">CATEGORIES</option>
              <c:forEach items="${categories}" var="category">
                  <option value="${category.id}">${category.name}</option>
              </c:forEach>
            </select>
          </div>
          <div>
            <input name="title" type="text" value="DVD TITLE" class="text" />
          </div>
          <div class="softright">
            <input type="image" src="resources/images/btn_search.gif" name="submit"/>
          </div>
        </form>
      </dd>
    </dl>
    <div id="body">
      <div class="inner">