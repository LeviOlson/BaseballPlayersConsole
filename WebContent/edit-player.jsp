<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<form action = "editPlayerServlet" method="post">
First Name: <input type ="text" name = "First name" value=
"${toEdit.FName}">
Last Name: <input type ="text" name = "Last name" value=
"${toEdit.LName}">
Number: <input type ="text" name = "Number" value=
"${toEdit.number}">
<input type = "hidden" name = "id" value="${toEdit.id}">
<input type = "submit" value="Save Edited Player">
</form>
</body>
</html>