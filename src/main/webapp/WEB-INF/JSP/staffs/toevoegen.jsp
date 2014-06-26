<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="staff toevoegen"/>
</head>
<body>
<v:menu/>
<h1>Voeg eeb staff member toe</h1>
<spring:url value="/staffs/toevoegen" var="url"/>
<form:form commandName="staffForm" method="post" action="${url}">
<form:label path="firstName">Voornaam: <form:errors path="firstName" cssClass="fout"/></form:label>
<form:input path="firstName"/>
<form:label path="lastName">Familienaam: <form:errors path="lastName" cssClass="fout"/></form:label>
<form:input path="lastName"/>
<form:label path="address">Address: <form:errors path="address" cssClass="fout"/></form:label>
<form:select path="address" items="${addresses}"  itemLabel="addresses" itemValue="id"/>
<%--email --%>
<form:label path="email">Email: <form:errors path="email" cssClass="fout"/></form:label>
<form:input path="email"/>
<form:label path="store">Store: <form:errors path="store" cssClass="fout"/></form:label>
<form:select path="store" items="${stores}" itemLabel="naam" itemValue="id"/>
<form:label path="username">Usernaam: <form:errors path="username" cssClass="fout"/></form:label>
<form:input path="username"/>
<form:label path="password">Paswoord: <form:errors path="password" cssClass="fout"/></form:label>
<form:password path="password"/>
<form:label path="repeat">Herhaal paswoord: <form:errors path="repeat" cssClass="fout"/></form:label>
<form:password path="repeat"/>
<input type="submit" value="Toevoegen">
</form:form>
</body>
</html>