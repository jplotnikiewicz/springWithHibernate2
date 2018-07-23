<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Spring Demo</title>
    </head>
    <body>
        <p>Inser User Id:</p>
        <form:form action="delete" modelAttribute="user" method="delete">
            <form:label path="id"> ID </form:label>
            <form:input path="id"/>
            <br/><br/>
            <input type="submit" value="Delete User"/>
        </form:form>
    </body>
</html>