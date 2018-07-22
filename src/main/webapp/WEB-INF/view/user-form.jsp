<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title> Spring with JDBC demo</title>
    </head>
    <bod> 
        <h2> User Data</h2>
        <form:form action="addUser" modelAttribute="user" method="post">
            
            <form:label path="name">Name</form:label>
            <form:input path="name"/>
            
            <form:label path="email">Email</form:label>
            <form:input path="email"/>
            
            <input type="submit" value="Submit">
        </form:form>
    </bod>
</html>