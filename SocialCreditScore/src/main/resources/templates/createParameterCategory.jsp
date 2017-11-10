<%@page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%> 
<%@taglib
         uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Create Focus</title>
    </head>
    <body>
        <form:form method="POST" commandName="parameterCategory"
                   action="/ParameterCategory/save">
            <ul>
                <li>
                    <div>
                        <label>Social Media Type</label>

                        <form:select path="socialMediaType.id" required="required">
                            <form:option value="" label="---Select---" />
                            <form:options items="${socialMediaTypeList}" />
                        </form:select>
                    </div>
                </li>
                <li>
                    <div>
                        <label>Parameter Category Name</label>
                        <form:input path="name" />
                    </div>
                </li>

                <li>
                    <div>
                        <label>Code</label>
                        <form:input path="categoryWeight" />
                    </div>
                </li>

                <li>
                    <div>
                        <label>Category Weight</label>
                        <form:input path="categoryWeight" />
                    </div>
                </li>

                <form:hidden path="id" />
                <li><a href="/ParameterCategory/display">Cancel</a> <input
                        type="submit" value="Save"></li>
            </ul>
        </form:form>

    </body>
</html>