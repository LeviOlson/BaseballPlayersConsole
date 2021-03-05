<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
	<form action="createNewRosterServlet" method="post">
		Team Name: <input type="text" name="team_name"><br /> 
		Players:<br /> <select name="allPlayersToAdd" multiple size="6">
			<c:forEach items="${requestScope.allPlayers}" var="currentplayer">
				<option value="${currentplayer.getId()}">${currentplayer.FName} ${currentplayer.LName} ${currentplayer.number} </option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Roster and Add Players">
	</form>
	<a href="index.html">Go create new players instead.</a>
</body>
</html>