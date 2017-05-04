<%-- 
    Document   : header
    Created on : 2-mag-2017, 10.14.09
    Author     : Giacomo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="LogoutBlock">
    <p>
        ${loggedUser.name} ${loggedUser.surname}
    </p>
    <p>
        <a href="Login?logout=1">Logout</a>
    </p>
</div>