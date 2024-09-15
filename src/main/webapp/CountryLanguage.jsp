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
            <div>
                <label for="countryCode">Country Code</label>
                <input type="text" id="countryCode" name="countryCode" />
            </div>
            <div>
                <label for="language">Country Language</label>
                <input type="text" id="language" name="language" />
            </div>

            <div> 
                <!-- use drop down for this -->
                <label for="isOfficial">Is Language Official</label> 
                <input type="text" id="isOfficial" name="isOfficial" /> 
            </div>

            <div>
                <label for="percentage">Percentage</label>
                <input type="text" id="percentage" name="percentage" />
            </div>

            
        </form>
    </body>
</html>
