<%-- 
    Document   : nav
    Created on : 2-mag-2017, 10.36.19
    Author     : Giacomo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="Menu">
    <a href="descrizione.html"><h1 class="NavHeader">Nerdbook</h1></a>
    
    <a <c:if test="${page=='bacheca'}">class="HeaderCurrentPage UnderLineBackG"</c:if> href="profilo.html"><h2 <c:if test="${page=='profilo'}">class="HeaderCurrentPage UnderLineBackG"</c:if> class="NavHeader">Profilo</h2></a>
    
    <a <c:if test="${page=='bacheca'}">class="HeaderCurrentPage UnderLineBackG"</c:if> href="Bacheca"><h2 class="NavHeader RBorder">Bacheca</h2></a>
</div>