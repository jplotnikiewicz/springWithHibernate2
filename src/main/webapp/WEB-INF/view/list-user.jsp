<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title> Spring JDBC demo</title>
    </head>
    <body>
        <h2> Users : </h2>
        <ul>
            <c:forEach var = "user" items ="${users}">
                <li> ${user.id}, ${user.name}, ${user.email}</li>
            </c:forEach>
        </ul>
    </body>
</html>