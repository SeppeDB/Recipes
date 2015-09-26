<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${recipe.name}</title>
</head>
<body>

	Recipe Name: ${recipe.name}
	<br /> Recipe Description: ${recipe.description}
	<br /> Preparation Time: ${recipe.time}
	<br /> Ingredients: ${recipe.ingredients}
	<br />
	<img src="data:image/png;base64, ${recipe.image} " alt="${recipe.name}" />

</body>
</html>