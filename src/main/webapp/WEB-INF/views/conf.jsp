<%-- 
    Document   : conf
    Created on : Sep 16, 2024, 8:58:05 AM
    Author     : AndrewZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Confirmation Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f7f9;
                color: #333;
                margin: 0;
                padding: 20px;
            }
            .container {
                max-width: 600px;
                margin: 0 auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #2c3e50;
                margin-bottom: 20px;
            }
            .info-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 12px;
                margin: 10px 0;
                background: #ecf0f1;
                border-radius: 5px;
            }
            .label {
                font-weight: bold;
                color: #34495e;
                flex: 1;
                text-align: right;
                padding-right: 10px;
            }
            .value {
                color: #2ecc71;
                flex: 2;
                text-align: left;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Confirmation Page</h1>
            <div class="info-item">
                <span class="label">Country Code:</span>
                <span class="value">${requestScope.countryLanguage.countryCode}</span>
            </div>
            <div class="info-item">
                <span class="label">Language:</span>
                <span class="value">${requestScope.countryLanguage.language}</span>
            </div>
            <div class="info-item">
                <span class="label">Is Official:</span>
                <span class="value">${requestScope.countryLanguage.isOfficial}</span>
            </div>
            <div class="info-item">
                <span class="label">Percentage:</span>
                <span class="value">${requestScope.countryLanguage.percentage}</span>
            </div>
        </div>
    </body>
</html>
