<%-- 
    Document   : CountryLanguage
    Created on : Sep 14, 2024, 6:02:00 PM
    Author     : AndrewZ
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Country</title>
    </head>
    <body>
        <h1>New Country Language Form</h1>
        

    <c:if test="${not empty requestScope.violations}">
        <h2>Please fix the following errors with your input:</h2>
        <table border="1">
            <tr>
                <th>Field</th>
                <th>Error</th>
            </tr>
            <c:forEach var="v" items="${requestScope.violations}">
                <tr>
                    <td><c:out value="${v.propertyPath}" /></td>
                <td><c:out value="${v.message}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>




    <form method="post" action="countrylanguage">
        <div>
            <label for="countryCode">Country Code</label>
            <input type="text" id="countryCode" name="countryCode" value="${requestScope.countryLanguage.countryCode}"/>
        </div>
        <div>
            <label for="language">Country Language</label>
            <input type="text" id="language" name="language" value="${requestScope.countryLanguage.language}"/>
        </div>

        <div> 
            <label for="isOfficial">Is Language Official?</label> 
            <select id="isOfficial" name="isOfficial" required>
                <option value="" disabled ${requestScope.countryLanguage.isOfficial == null ? 'selected' : ''}>Select True or False</option>
                <option value="true" ${requestScope.countryLanguage.isOfficial ? 'selected' : ''}>True</option>
                <option value="false" ${requestScope.countryLanguage.isOfficial != null && !requestScope.countryLanguage.isOfficial ? 'selected' : ''}>False</option>
            </select>
        </div>

        <div>
            <label for="percentage">Percentage</label>
            <input type="text" id="percentage" name="percentage" value="${requestScope.countryLanguage.percentage}"/>
        </div>

        <button type="submit">Submit</button>
    </form>

</body>
</html>
