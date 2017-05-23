<%-- 
    Document   : bachGroup
    Created on : 3-mag-2017, 12.44.02
    Author     : Giacomo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca Nerdbook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giacomo Medda">
        <meta name="keywords" content="bacheca nerdbook post image">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>
        <div id="Header">
            <jsp:include page="header.jsp"/>
            <c:set var="page" value="bacheca" scope="request"/>
            <jsp:include page="nav.jsp"/>
        </div>
        
        <div id="Page">
            <jsp:include page="sidebar.jsp"/>

            <div id="BachContent">
                <h2>${currGrp.group.name}</h2>
                <c:forEach var="post" items="${posts}">
                    <div class="Post">
                        <img title="imgProfilo" alt="Foto Profilo"
                         src="${post.sharer.profImagePath}" width="100" height="80">
                        <p>${post.sharer.name} ${post.sharer.surname}</p>
                        <div class="contentPost">
                            <p>${post.content}</p>
                            <c:if test="${post.postType == IMAGE}">
                                <img alt="Post con foto" src="${post.postContent}">
                            </c:if>
                            <c:if test="${post.postType == 'TEXT'}">
                                <p>${post.postContent}</p>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
