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
	
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="authenticated.request.form.label.reward" path="reward"  readonly="true"/>
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
	<acme:form-double code="authenticated.request.form.label.amount" path="amount"/>
	<acme:form-select code="authenticated.request.form.label.currency" path="currency">
	<acme:form-option code="authenticated.request.form.label.euro" value="EUR"/>
	</acme:form-select>
	</jstl:if>

	<acme:form-textbox code="authenticated.request.form.label.ticker" path="ticker"/>
	<jstl:if test="${command == 'create'}">
	<acme:message code="authenticated.request.form.message.explanation"/>
	<acme:form-checkbox code="authenticated.request.form.checkbox.agree" path="accept"/>
	</jstl:if>
	
	
	
	<acme:form-submit test ="${command == 'create'}" code="authenticated.request.form.button.create" action="/authenticated/request/create"/>
	<acme:form-return code="authenticated.request.form.label.button.return"/>
</acme:form>