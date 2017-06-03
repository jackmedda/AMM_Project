<%-- 
    Document   : sidebar
    Created on : 2-mag-2017, 12.22.23
    Author     : Giacomo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="Line"></div>
<div id="Sidebar">
    <div id="Filter">
        <input id="searchFriend" type="text" placeholder="Cerca i tuoi amici..." value=""/>
        <button id="searchButton">Cerca</button>
    </div>
    <h3>Amici</h3>
    <div id="userFriends">
        <ul>
        <c:forEach var="friend" items="${friends}"> 
           <a href="Bacheca?user=${friend.id}"><li>${friend.name} ${friend.surname}</li></a>
        </c:forEach>
        </ul>
    </div>
    
    <h3>Gruppi</h3>
    <div id="userGroups">
        <ul>
        <c:forEach var="grp" items="${groups}"> 
            <a href="Bacheca?group=${grp.id}"><li>${grp.group.name}</li></a>
        </c:forEach>
        </ul>
    </div>
</div>
              

