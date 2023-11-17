<%@ page import="org.example.Models.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Models.Actor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/13/2023
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Film film = (Film) request.getAttribute("film");
%>
<h2><%=film.getName() %></h2>
<br/>
Director: <%=film.getDirector().getFullName() %>
<br/>
Year of issue: <%=film.getIssuedAt().toString() %>
<br/>
Actors: <%
    for(Actor actor : film.getActors()) {
%>
<%=actor.getFullName()%>
<br/>
<%
    }
%>
</body>
</html>
