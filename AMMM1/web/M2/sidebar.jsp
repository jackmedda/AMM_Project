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
            <a href="Bacheca?user=${friend.id}"><li>${friend.name} ${friend.surname}</li></a>
        </ul>
    </c:forEach>
    
    <h3>Gruppi</h3>
    <c:forEach var="grp" items="${groups}"> 
        <ul>
            <a href="Bacheca?group=${grp.id}"><li>${grp.group.name}</li></a>
        </ul>
    </c:forEach>
</div>
              

