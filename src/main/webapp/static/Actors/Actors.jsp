<%@ page import="java.util.List" %>
<%@ page import="org.example.Models.Actor" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/13/2023
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 3px solid black;
            border-collapse: collapse;
        }
    </style>
    <title>Title</title>
</head>
<body>
<table id="example" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Id</th>
        <th>Full name</th>
        <th>Date of birth</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Actor> actors = (List) request.getAttribute("actors");
        for(Actor actor : actors) {
    %>
    <tr>
        <td>
            <a href="http://localhost:8080/JspApi_war/actor/<%=Integer.toString(actor.getId()) %>">
                <%=Integer.toString(actor.getId()) %>
            </a>
        </td>
        <td><%=actor.getFullName() %></td>
        <td><%=actor.getDateOfBirth().toString() %></td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>
</body>
</html>
