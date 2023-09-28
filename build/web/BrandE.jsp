<%-- 
    Document   : BrandE
    Created on : Jul 20, 2023, 1:25:03 PM
    Author     : march
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Brand" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <h1>Edit brand</h1>
        <%
            Brand brand = (Brand) session.getAttribute("brand");
        %>
        <form action="AddBrandzx">
            Name:<input type="text" name="name" value="<%= brand.getName()%>"><br/>
            Type: <input type="text" name="type" value="<%= brand.getType()%>"><br/>
            Price: <input type="text" name="price" value="<%= brand.getPrice()%>"><br/>
            <input type="submit" value="Edit">
        </form>
        <% session.removeAttribute("brand");%>
    </body>
</html>
