<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Film op titel"></v:head>
</head>
<body>
<div id="container">
	<v:menu />
	<h1>Films op naam</h1>
	<c:url value="/films/optitel" var="url" />
	<form:form method="get" commandName="filmTitel" action="${url}">
		<form:label path="titel">Begin van de titel:<form:errors path="titel" cssClass="fout" />
		</form:label>
		<form:input path="titel" autofocus='true' required='true' />
		<input type="submit" value="Zoeken">
		<form:errors cssClass='fout' element='div' />
	</form:form>
	<c:if test="${not empty films}">
		<table>
			<tr>
				<td>titel</td>
				<td>Release jaar</td>
				<td>Rating</td>
			</tr>
			<c:forEach items="${films}" var="film">
				<spring:url value="/films/{id}" var="filmURL">
					<spring:param name="id" value="${film.id}" />
				</spring:url>
				<tr>
					<td><a href="${filmURL}">${film.title}</a></td>
					<td class="number"><spring:eval expression="film.releaseYear" /></td>
					<td>${film.rating}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
</body>
</html>