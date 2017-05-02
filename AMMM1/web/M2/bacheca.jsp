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
            <div id="Line"></div>
            <div id="Sidebar">
                <h3>Persone</h3>
                <ul>
                    <li>Pinco Pallino</li>
                    <li>Riccardo Rossi</li>
                    <li>Mario Bianchi</li>
                </ul>

                <h3>Gruppi</h3>
                <ul>
                    <li>Mongolfieristi</li>
                    <li>Ritardatari</li>
                </ul>
            </div>

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
                <div class="Post">
                    <img title="imgProfilo" alt="Foto Profilo"
                         src="images/cookieMonsterProf.jpg" width="100" height="80">
                    <p>Cookie Monster</p>

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