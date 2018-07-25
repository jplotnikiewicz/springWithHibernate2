<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<title> Spring Demo</title>
	</head>
	<body>
		<form:form action="editEmaiil" modelAttribute="user" method="post">
			<p>Insert User ID</p>
			<form:label path="id">ID : </form:label>
			<form:input path="id"/>
			<br/>
			<form:label path="email">Email : </form:label>
			<form:input path="email"/>
			<br/><br/>
			<input type="submit" value="Change Email for user">
		</form:form>
	</body>
</html>