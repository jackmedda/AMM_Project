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
                <div id="newPost">
                    <p id="confirmPostFr"><c:if test="${riep == 2}">Il post è stato scritto sulla bacheca 
                            di ${currGrp.group.name}</c:if></p>
                    <c:choose>
                        <c:when test="${riep == 1}">
                            <form action="bacheca.html?riepilogo=2&group=${currGrp.id}" method="POST">
                                <div id="divForm">
                                    <div class="row">
                                        <label class="label_ta" for="formFriendBach">Testo Post</label>
                                        <textarea rows="4" cols="10" 
                                                  name="formFriendBach" id="formFriendBach">${message}</textarea>
                                    </div>
                                    <div class="row">
                                        <label for="imagePost">Path o Url Immagine</label>
                                        <input type="text" name="imagePost" id="imagePost" value="${image}"/>
                                    </div>
                                    <p>Vuoi davvero inviare questo post alla bacheca di ${currGrp.group.name}?</p>
                                </div>
                            <button type="submit">Invia</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <h2>Scrivi qualcosa sul diario di ${currGrp.group.name}</h2>
                            <form action="bacheca.html?riepilogo=1&group=${currGrp.id}" method="POST">
                                <div id="divForm">
                                    <div class="row">
                                        <label class="label_ta" for="formFriendBach">Testo Post</label>
                                        <textarea rows="4" cols="10" name="formFriendBach" id="formFriendBach"></textarea>
                                    </div>
                                    <div class="row">
                                        <label for="imagePost">Path o Url Immagine</label>
                                        <input type="text" name="imagePost" id="imagePost"/>
                                    </div>
                                </div>
                                <button type="submit">Invia</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div id="sharedPosts">
                    <h2>${currGrp.group.name}</h2>
                    <c:forEach var="post" items="${posts}">
                        <div class="Post">
                            <img title="imgProfilo" alt="Foto Profilo"
                             src="${post.sharer.profImagePath}" width="100" height="80">
                            <p>${post.sharer.name} ${post.sharer.surname}</p>
                            <div class="contentPost">
                                <p>${post.content}</p>
                                <c:if test="${post.postType == 'IMAGE'}">
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
        </div>
    </body>
</html>
