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
                <h2>Post condivisi</h2>
                <c:forEach var="post" items="${posts}">
                    <div class="Post">
                        <img title="imgProfilo" alt="Foto Profilo"
                         src="${user.urlProfImage}" width="100" height="80">
                        <p>${user.nome} ${user.cognome}</p>
                        <div class="contentPost">
                            <p>${post.content}</p>
                            <c:if test="${post.imagePath != null}">
                                <img alt="Post con foto" src="${post.imagePath}">
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>