<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="stores"/>
</head>
<body>
<div id="container">
<v:menu/>
<h1>Stores</h1>
<a href='<c:url value="/stores/toevoegen"/>'>Store toevoegen</a>
<table>
<tr>
<td>Address</td>
<td>Manager</td>
</tr>
<c:forEach items="${stores}" var="store">
<tr>
<td>${store.address.address} ${store.address.district}</td>
<td>${store.manager.naam}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>