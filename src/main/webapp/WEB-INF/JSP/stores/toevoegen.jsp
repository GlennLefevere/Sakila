<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="nieuwe store"/>
</head>
<body>
<div id="container">
<v:menu/>
<h1>Voeg een nieuwe store toe</h1>
<spring:url value="/stores/toevoegen" var="url"/>
<form:form commandName="storeForm" method="post" action="${url}">
<form:label path="staff">Kies een manager: <form:errors path="staff" cssClass="fout"/></form:label>
<form:select path="staff" items="${staffs}" itemValue="id" itemLabel="naam" size="5"/>
<form:label path="address">Kies een store: <form:errors path="address" cssClass="fout"/></form:label>
<form:select path="address" items="${addresses}" itemValue="id" itemLabel="addresses" size="5"/>
<input type="submit" value="Toevoegen">
</form:form>
</div>
</body>
</html>