<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Spring Demo</title>
    </head>
    <body>
        <p>Inser User Id:</p>
        <form:label path="id"> ID </form:label>
        <form:input path="id"/>
        <input type="submit" value="Submit"/>
    </body>
</html>