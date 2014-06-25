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
<v:menu/>
<h1>Voeg een nieuwe store toe</h1>
<form:form commandName="storeForm">
<form:label path="staff">Kies een manager: <form:errors path="staff" cssClass="fout"/></form:label>
<form:select path="staff" items="${staffs}" itemValue="id" itemLabel="naam"/>
<form:label path="address">Kies een manager: <form:errors path="address" cssClass="fout"/></form:label>
<form:select path="address" items="${addresses}" itemValue="id" itemLabel="addresses"/>
</form:form>
</body>
</html>