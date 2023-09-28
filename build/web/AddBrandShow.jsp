<%-- 
    Document   : AddBrandShow
    Created on : Jul 20, 2023, 1:15:10 PM
    Author     : march
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Brand"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Brand Successfully</h1>
        <%
            Brand brand = (Brand) session.getAttribute("brand");
        %>
        Name: <%= brand.getName()%><br/>
        Type: <%= brand.getType()%><br/>
        Price:<%= brand.getPrice()%><br/>
        <a href="BrandE.jsp">Edit</a>
    </body>
</html>
