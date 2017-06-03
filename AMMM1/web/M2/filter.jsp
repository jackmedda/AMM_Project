<%-- 
    Document   : filter
    Created on : 3-giu-2017, 17.56.59
    Author     : Giacomo
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="user" items="${listaUsers}">
        <json:object>
            <json:property name="name" value="${user.name}"/>
            <json:property name="surname" value="${user.surname}"/>
            <json:property name="id" value="${user.id}"/>
        </json:object>
    </c:forEach>
</json:array>