<%@page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Existing Parameter Category</title>
    </head>
    <body>
        <div>
            <div>
                <h3>Existing Parameter Category</h3>
                <table>
                    <tr>
                        <th>Parameter Category Code</th>
                        <th>Parameter Category Name</th>
                        <th>Social Media Type</th>
                        <th>Category Weight</th>
                        <th>View/Update</th>
                    </tr>

                    <c:forEach var="param" items="${paramsView}">

                        <tr>
                            <td><c:out value="${param.code}" /></td>
                            <td><c:out value="${param.name}" /></td>
                            <td><c:out value="${param.socialMediaType}" /></td>
                            <td><c:out value="${param.categoryWeight}" /></td>
                            <td><a href=<c:url value='view/${param.id}'/>><button
                                        value="Edit">View/Update</button></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>