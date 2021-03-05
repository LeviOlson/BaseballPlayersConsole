<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Lists</title>
</head>
<body>
	<form method="post" action="rosterNavigationServlet">
		<table>
			<c:forEach items="${requestScope.allRosters}" var="currentroster">
				<tr>
					<td><input type="radio" name="id" value="${currentroster.id}"></td>
				</tr>
				<tr>
					<td colspan="3">Team: ${currentroster.team.teamName}</td>
				</tr>
				<c:forEach var="rosterVal" items="${currentroster.listOfPlayers}">
					<tr>
						<td></td>
						<td colspan="3">${rosterVal.number}, ${rosterVal.FName}, ${rosterVal.LName} }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="delete" name="doThisToRoster"> 
		<input type="submit" value="add" name="doThisToRoster">
	</form>
	<a href="addPlayersForRosterServlet">Create a new roster</a>
	<a href="index.html">Insert a new player</a>
</body>
</html>