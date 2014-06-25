<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="${film.title}"/>
</head>
<body>
<h1>${film.title}</h1>
<c:if test="${not empty film.filmActors }">
<ul>
<c:forEach items="${film.filmActors}" var="filmActor">
	<li>${filmActor.actor.firstName} ${filmActor.actor.lastName}</li>
</c:forEach>
</ul>
</c:if>
<spring:url value="/films/{id}" var="url">
	<spring:param name="id" value="${film.id}"/>
</spring:url>
<form:form action="${url}" method="get" commandName="acteurNaam">
	<form:label path="naamdeel">Geef een deel van de familienaam in:<form:errors path="naamdeel" cssClass="fout"/></form:label>
	<form:input path="naamdeel" autofocus="true" />
	<input type="submit" value="zoeken">
</form:form>
<c:if test="${not empty acteurs}">
 
<spring:url value="/films/{id}/toevoegen" var="toevoegUrl">
	<spring:param name="id" value="${film.id}"/>
	<spring:param name="naamdeel" value="${acteurNaam.naamdeel}"/>
</spring:url>
<form:form commandName="actorForm" action="${toevoegUrl}" method="post">
<form:label path="actor">Selecteer een acteur: <form:errors cssClass="fout" path="actor"/> </form:label>
<form:select path="actor" items="${acteurs}" itemLabel="name" itemValue="id" size="5"/>
<input type="submit" value="Voeg toe">
</form:form>
</c:if>
</body>
</html>