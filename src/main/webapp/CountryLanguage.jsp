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

        <form method="post" action="countrylanguage">
            <div>
                <label for="countryCode">Country Code</label>
                <input type="text" id="countryCode" name="countryCode" />
            </div>
            <div>
                <label for="language">Country Language</label>
                <input type="text" id="language" name="language" />
            </div>

            <div> 
                <label for="isOfficial">Is Language Official?</label> 
                <select id="isOfficial" name="isOfficial" required>
                    <option value="" disabled selected>Select True or False</option>
                    <option value="true">True</option>
                    <option value="false">False</option>
                </select>
            </div>

            <div>
                <label for="percentage">Percentage</label>
                <input type="text" id="percentage" name="percentage" />
            </div>

            <button type="submit">Submit</button>
        </form>

    </body>
</html>
