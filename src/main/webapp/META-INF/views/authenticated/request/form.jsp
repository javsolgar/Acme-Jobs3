<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.request.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.request.form.label.description" path="description"/>
	<acme:form-moment code="authenticated.request.form.label.moment" path="moment"/>
	<acme:form-moment code="authenticated.request.form.label.deadline" path="deadLine"/>
	<acme:form-money code="authenticated.request.form.label.reward" path="reward"/>
	<acme:form-textbox code="authenticated.request.form.label.ticker" path="ticker"/>
	
	
	<acme:form-return code="authenticated.request.form.label.button.return"/>
</acme:form>