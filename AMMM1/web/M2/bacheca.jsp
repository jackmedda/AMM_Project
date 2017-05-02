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

                <div class="Post">
                    <img title="imgProfilo" alt="Foto Profilo"
                             src="images/cookieMonsterProf.jpg" width="100" height="80">
                    <p>Cookie Monster</p>

                    <div class="contentPost">
                        <p>
                            Oggi al caddozzone si va a festeggiare.
                        </p>  
                    </div>
                </div>
                <c:forEach var="post" items="${posts}">
                    <div class="Post">
                        <img title="imgProfilo" alt="Foto Profilo"
                         src="images/cookieMonsterProf.jpg" width="100" height="80">
                        <p>${user.nome} ${user.cognome}</p>
                        <div class="contentPost">
                            <p>${post.content}</p>
                            <c:if test="${post.imagePresent == true}">
                                <img alt="Post con foto" src="${post.imagePath}">
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
                <div class="Post">
                    

                    <div class="contentPost">    
                        <p>
                            Cassato!!!
                        </p>
                        <img title="fotoPost" alt="Foto di un Post"
                                 src="images/cookieMonster.gif" width="480" height="360">
                    </div>
                </div>
                <div class="Post">
                    <img title="imgProfilo" alt="Foto Profilo"
                         src="images/cookieMonsterProf.jpg" width="100" height="80">
                    <p>Cookie Monster</p>

                    <div class="contentPost">
                        <p>
                            Epico, impossibile non guardarlo!
                        </p>
                        <a href="https://www.youtube.com/watch?v=FWHneYtED8I">https://www.youtube.com/watch?v=FWHneYtED8I</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>