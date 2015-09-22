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
		var newdiv = document.createElement('div');
		newdiv.innerHTML = "Ingredient "
				+ (counter + 1)
				+ ' <br><input type="text" name="ingredients[]" placeholder="Ingredient" autofocus>';
		document.getElementById(divName).appendChild(newdiv);
		counter++;
	}
</script>

</head>
<body>

	<form method="POST" enctype="multipart/form-data">
		<input type="text" name="name" placeholder="Name Recipe"><br />
		<input type="text" name="description" placeholder="Description"><br />
		<input type="time" name="time"> <br /> <br />

		<div id="ingredients">
			<input type="text" name="ingredients[]" placeholder="Ingredient"><br />
		</div>

		<input type="button" value="Add ingredient"
			onClick="addInput('ingredients');"><br />
		<br /> <input type="file" name="image" /> <input type="submit"
			value="Submit Recipe">
	</form>


</body>
</html>