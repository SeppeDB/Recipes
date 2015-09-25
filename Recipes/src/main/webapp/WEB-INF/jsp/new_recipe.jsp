<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Recipe</title>
<script type="text/javascript">
	var counter = 1;
	function addInput(divName) {
		var counter = 1;
		var newdiv = document.createElement('div');
		newdiv.innerHTML = "Ingredient " + (counter + 1)
				+ ' <input type="text" name="ingredients[]" >';
		document.getElementById(divName).appendChild(newdiv);
		counter++;
	}
</script>

</head>
<body>

	<form method="POST" enctype="multipart/form-data">
		Name:<input type="text" name="name" placeholder="Name Recipe"
			value="${recipeForm.name}"><br /> Description:<input
			type="text" name="description" value="${recipeForm.description}"><br />
		Time:<input type="time" name="time" value="${recipeForm.time}">
		<br /> <br />

		<div id="ingredients">
			Ingredient 1:<input type="text" name="ingredients[]"
				placeholder="Ingredient"><br />
		</div>
		<input type="button" value="Additional Ingredient"
			onClick="addInput('ingredients');"><br /> <br /> <input
			type="file" name="image" /> <input type="submit"
			value="Submit Recipe">
	</form>


</body>
</html>