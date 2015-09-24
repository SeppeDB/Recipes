<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recipe List</title>
</head>
<body>
	<form method="POST">
		<input type="submit" value="Add Recipe" />
	</form>

	<br />
	<table style="width: 80%" border="1">
		<c:forEach var="recipes" items="${recipes}">
			<tr>
				<td><c:out value="${recipes.name}" /></td>
				<td><c:out value="${recipes.description}" /></td>
				<td><c:out value="${recipes.time}" /></td>
				<td><img src="data:image/png;base64, ${recipes.image} "
					height="100px" width="100px" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>