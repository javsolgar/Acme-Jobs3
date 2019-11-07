<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textarea code="administrator.configuration.form.label.spamThreshold" path="spamThreshold"/>
	<acme:form-textbox code="administrator.configuration.form.label.spamWords" path="spamWords"/>
	
	
	<acme:form-return code="administrator.configuration.form.label.button.return"/>
</acme:form>