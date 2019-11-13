<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.request.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.request.form.label.description" path="description"/>
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="authenticated.request.form.label.moment" path="moment"  readonly="true"/>
	</jstl:if>
	<acme:form-moment code="authenticated.request.form.label.deadline" path="deadLine"/>
	<acme:form-money code="authenticated.request.form.label.reward" path="reward"/>
	<acme:form-textbox code="authenticated.request.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'create'}">
	<acme:message code="authenticated.request.form.message.explanation"/>
	<acme:form-checkbox code="authenticated.request.form.checkbox.agree" path="remember"/>
	</jstl:if>
	
	
	
	<acme:form-submit test ="${command == 'create'}" code="authenticated.request.form.button.create" action="/authenticated/request/create"/>
	<acme:form-return code="authenticated.request.form.label.button.return"/>
</acme:form>