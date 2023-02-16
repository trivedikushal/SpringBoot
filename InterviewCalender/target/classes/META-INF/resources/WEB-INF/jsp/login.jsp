<!-- To use foreach, if, etc... -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="/webjars/bootstrap/5.2.1/css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class="container">
			<form method="post">
				Username:<input type="text" name="username"></br></br>
				Password:<input type="password" name="password"></br></br>
				<input type="submit" value="Login" class="btn btn-success">
			</form>
		</div>
		<script src="/webjars/bootstrap/5.2.1/js/bootstrap.min.js"></script>
		<script src="/webjars/jquery/3.6.3/jquery.min.js"></script>
	</body>
</html>