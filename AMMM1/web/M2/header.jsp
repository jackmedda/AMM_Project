<%-- 
    Document   : header
    Created on : 2-mag-2017, 10.14.09
    Author     : Giacomo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <div id="LogoutBlock">
        <p>
            ${user.nome} ${user.cognome}
        </p>
        <p>
            <a href="login.html">Logout</a>
        </p>
    </div>
</header>
