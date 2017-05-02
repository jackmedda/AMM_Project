<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Creazione profilo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giacomo Medda">
        <meta name="keywords" content="nerd profilo nerdbook creare">
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
            
            <div id="profImageBox">
                <c:choose>
                    <c:when test="${user.urlImagePath == null}">
                        +
                    </c:when>
                    <c:otherwise>
                        <img alt="Foto Profilo" src="${user.urlProfImage}">
                    </c:otherwise>
                </c:choose>
            </div>

            <form action="profilo.html" method="POST">
                <div id="divForm">
                    <div class="row">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name"
                               <c:if test="${user.name != null}">value="${user.name}"</c:if>/>
                    </div>
                    <div class="row">
                        <label for="surname">Cognome</label>
                        <input type="text" name="surname" id="surname"
                               <c:if test="${user.surname != null}">value="${user.surname}"</c:if>/>
                    </div>
                    <div class="row">
                        <label for="name">Url dell'immagine del profilo</label>
                        <input type="url" name="imgUrl" id="imgUrl"
                               <c:if test="${user.urlProfImage != null}">value="${user.urlProfImage}"
                               </c:if> />                       
                    </div>
                    <div class="row">
                        <label for="present" id="label_ta">Frase di presentazione</label>
                        <textarea rows="4" cols="10"
                                  name="present" id="present"></textarea>
                    </div>
                    <div class="row">
                        <label for="date">Data di nascita</label>
                        <input type="date" name="date" id="date" value="2000-01-01"/>
                    </div>
                    <div class="row">
                        <label for="pswd">Password</label>
                        <input type="password" name="pswd"
                               id="pswd"/>
                    </div>
                    <div class="row">
                        <label for="verPswd">Conferma password</label>
                        <input type="password" name="verPswd"
                               id="verPswd"/>
                    </div>
                </div>
                <button type="submit">Aggiorna</button>
            </form>
        </div>
    </body>
</html>