<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login Nerdbook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giacomo Medda">
        <meta name="keywords" content="login nerdbook nerd username password">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <h1 id="titleLogin">Nerdbook</h1>
        <div id="formLogin">
            <h2>Accedi</h2>
            
            <c:if test="${invalidData == true}">
                <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
            
            <form action="Login" method="POST">
                <div class="row">
                    <label for="userName">Username</label>
                    <input type="text" name="username" id="userName"/>
                </div>
                <div class="row">
                    <label for="passWord">Password</label>
                    <input type="password" name="password" id="passWord"/>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>