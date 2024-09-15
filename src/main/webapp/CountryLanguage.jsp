<%-- 
    Document   : CountryLanguage
    Created on : Sep 14, 2024, 6:02:00 PM
    Author     : AndrewZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create New Country</title>
    </head>
    <body>
        <h1>New Country Language Form</h1>
        
        <form method="post" action="/azhang20-fp/countrylanguage">
            <label for="countryCode">Country Code</label>
            <input type="text" id="countryCode" name="countryCode" />
            
            <label for="language">Country Language</label>
            <input type="text" id="language" name="language" />
            
            <label for="isOfficial">Is Language Official</label>
            <input type="text" id="isOfficial" name="isOfficial" />
            
            <label for="percentage">Percentage</label>
            <input type="text" id="percentage" name="percentage" />
            
            
        </form>
    </body>
</html>
