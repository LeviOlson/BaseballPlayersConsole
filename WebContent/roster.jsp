<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>roster</title>
</head>
<form method = "post" action = "navigationServlet">
<table>
<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
<tr>
 <td><input type="radio" name="id" value="${currentplayer.id}"></td>
 <td>${currentplayer.number}</td>
 <td>${currentplayer.FName}</td>
 <td>${currentplayer.LName}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "delete" name="doThisToPlayer">
<input type="submit" value = "add" name = "doThisToPlayer">
</form>
<body>

</body>
</html>