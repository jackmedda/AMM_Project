<%-- 
    Document   : sidebar
    Created on : 2-mag-2017, 12.22.23
    Author     : Giacomo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="Line"></div>
<div id="Sidebar">
    <h3>Persone</h3>
    <c:forEach var="friend" items="${friends}"> 
        <ul>
            <li>${friend.nome} ${friend.cognome}</li>
        </ul>
    </c:forEach>
    
    <h3>Gruppi</h3>
    <c:forEach var="group" items="${groups}"> 
        <ul>
            <li>${group.nome} ${group.cognome}</li>
        </ul>
    </c:forEach>
</div>
              

