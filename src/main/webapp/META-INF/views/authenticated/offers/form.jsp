<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.offers.form.label.title" path="title"/>
	<acme:form-textarea code="authenticated.offers.form.label.description" path="description"/>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-moment code="authenticated.offers.form.label.moment" path="moment"/>
	</jstl:if>
	
	<acme:form-moment code="authenticated.offers.form.label.deadline" path="deadline"/>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-textbox code="authenticated.offers.form.label.lower" path="lowerRange"/>
	<acme:form-textbox code="authenticated.offers.form.label.major" path="majorRange"/>
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
	<acme:form-double code="authenticated.offers.form.label.amountMajor" path="amountMajor"/>
	
	<acme:form-double code="authenticated.offers.form.label.amountLower" path="amountLower"/>
	<acme:form-select code="authenticated.offers.form.label.currency" path="currency">
	<acme:form-option code="authenticated.offers.form.label.euro" value="EUR"/>
	</acme:form-select>
	</jstl:if>
	
	<acme:form-textbox code="authenticated.offers.form.label.ticker" path="ticker"/>
	
	<acme:form-submit test ="${command == 'create'}" code="authenticated.request.form.button.create" action="/authenticated/offers/create"/>
	<acme:form-return code="authenticated.offers.form.label.button.return"/>
</acme:form>