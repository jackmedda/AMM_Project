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
        <script src="../js/jquery-3.2.1.min.js"></script>
        <script src="../js/searchFriends.js"></script>
    </head>

    <body>
        <div id="Header">
            <jsp:include page="header.jsp"/>
            <c:set var="page" value="profilo" scope="request"/>
            <jsp:include page="nav.jsp"/>
        </div>
        
        <div id="Page">
            <jsp:include page="sidebar.jsp"/>
            
                <c:choose>
                    <c:when test="${utente.profImagePath == null}">
                        <div id="profImageBox">
                            +
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div id="profImage">
                            <img alt="Foto Profilo" src="${utente.profImagePath}">
                        </div>
                    </c:otherwise>
                </c:choose>

            <c:if test="${confirmed == true}"><p>I dati sono stati inseriti correttamente.</p></c:if>
            <c:if test="${passEquals == false}"><p>Le password non coincidono, reinserire i dati.</p></c:if>
            
            <form id="formProf" action="profilo.html?submitted=true" method="POST">
                <div id="divForm">
                    <div class="row">
                        <label for="name">Nome</label>
                        <input type="text" name="name" id="name"
                               <c:if test="${utente.name != null}">value="${utente.name}"</c:if>/>
                    </div>
                    <div class="row">
                        <label for="surname">Cognome</label>
                        <input type="text" name="surname" id="surname"
                               <c:if test="${utente.surname != null}">value="${utente.surname}"</c:if>/>
                    </div>
                    <div class="row">
                        <label for="name">Path o URL dell'immagine del profilo</label>
                        <input type="text" name="imgUrl" id="imgUrl"
                               <c:if test="${utente.profImagePath != null}">value="${utente.profImagePath}"
                               </c:if> />
                    </div>
                    <div class="row">
                        <label for="present" class="label_ta">Frase di presentazione</label>
                        <textarea rows="4" cols="10" name="present" 
                            id="present"><c:if test="${utente.presentation != null}">${utente.presentation}</c:if></textarea>
                    </div>
                    <div class="row">
                        <label for="date">Data di nascita</label>
                        <input type="date" name="date" id="date" 
                            <c:choose>
                                <c:when test="${utente.date != null}">value="${utente.date}"</c:when>
                                <c:otherwise>value="2000-01-01"</c:otherwise>
                            </c:choose>
                        />
                    </div>
                    <div class="row">
                        <label for="pswd">Password</label>
                        <input type="password" name="pswd" id="pswd"
                               <c:if test="${utente.password != null}">value="${utente.password}"
                               </c:if> />
                    </div>
                    <div class="row">
                        <label for="verPswd">Conferma password</label>
                        <input type="password" name="verPswd" id="verPswd"
                               <c:if test="${utente.password != null}">value="${utente.password}"
                               </c:if> />
                    </div>
                </div>
                <button type="submit">Aggiorna</button>
            </form>
            <form id="deleteButton" action ="profilo.html?delete=true"method="POST">
                <button type="submit">Elimina profilo</button>
            </form>
        </div>
    </body>
</html>