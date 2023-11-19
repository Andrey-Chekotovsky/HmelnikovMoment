<%@ page import="org.example.Models.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.Constants.WebConstants" %>
<%@ page import="org.example.Models.Director" %>
<%@ page import="org.example.Models.Actor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/19/2023
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<thead>
<tr>
    <th>Id</th>
    <th>name</th>
    <th>Issued at</th>
    <th>Full director name</th>

</tr>
</thead>
<tbody>
<%
    List<Film> films = (List) request.getAttribute("current_films");
    List<Actor> directors = (List) request.getAttribute("actors_directors");
    List<Actor> actors = (List) request.getAttribute("actors_n_films");
    for(Film film : films) {
%>
<tr>
    <td>
        <a href="http://localhost:8080/JspApi_war<%=WebConstants.prefix%>/film/<%=Integer.toString(film.getId()) %>">
            <%=Integer.toString(film.getId()) %>
        </a>
    </td>
    <td><%=film.getName() %></td>
    <td><%=film.getIssuedAt().toString() %></td>
    <td><%=film.getDirector().getFullName() %></td>
</tr>
<%
    }
%>
<form action="<%="http://localhost:8080/JspApi_war" + WebConstants.prefix +"/task" %>" method="post">
    <input type="hidden" name="_method" value="DELETE"><jsp:text /></input>
    Years: <input type="text">
    <input type="submit" value="Delete" />
</form>
</tbody>
</body>
</html>
