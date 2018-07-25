<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Spring Demo</title>
    </head>
    <body>
        <p>Insert User Id:</p>
        <form:form action="viewUser" modelAttribute="user" method="get">
            <form:label path="id"> ID </form:label>
            <form:input path="id"/>
            <br/><br/>
            <input type="submit" value="Find User"/>
        </form:form>
    </body>
</html>