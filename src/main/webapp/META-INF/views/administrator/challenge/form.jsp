<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.challenge.form.label.title" path="title"/>
	<acme:form-textarea code="administrator.challenge.form.label.description" path="description"/>
	<acme:form-moment code="administrator.challenge.form.label.deadline" path="deadline"/>
	<acme:form-textarea  code="administrator.challenge.form.label.goalGold" path="goalGold"/>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-money code="administrator.challenge.form.label.rewardGold" path="rewardGold"/>	
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
	<acme:form-double code="administrator.request.form.label.amountGold" path="amountGold"/>
	<acme:form-select code="administrator.request.form.label.currency" path="currencyGold">
	<acme:form-option code="administrator.request.form.label.euro" value="EUR"/>
	</acme:form-select>
	</jstl:if>
	
	<acme:form-textarea code="administrator.challenge.form.label.goalSilver" path="goalSilver"/>
	
	<jstl:if test="${command != 'create'}">
	<acme:form-money code="administrator.challenge.form.label.rewardSilver" path="rewardSilver"/>	
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
	<acme:form-double code="administrator.request.form.label.amountSilver" path="amountSilver"/>
	<acme:form-select code="administrator.request.form.label.currency" path="currencySilver">
	<acme:form-option code="administrator.request.form.label.euro" value="EUR"/>
	</acme:form-select>
	</jstl:if>
	
	<acme:form-textarea  code="administrator.challenge.form.label.goalBronze" path="goalBronze"/>	
	
	<jstl:if test="${command != 'create'}">
	<acme:form-money code="administrator.challenge.form.label.rewardBronze" path="rewardBronze"/>
	</jstl:if>
	
	<jstl:if test="${command == 'create'}">
	<acme:form-double code="administrator.request.form.label.amountBronze" path="amountBronze"/>
	<acme:form-select code="administrator.request.form.label.currency" path="currencyBronze">
	<acme:form-option code="administrator.request.form.label.euro" value="EUR"/>
	</acme:form-select>
	</jstl:if>

	
	

	<acme:form-submit test ="${command == 'show'}" code="administrator.challenge.form.button.update" action="/administrator/challenge/update"/>
	<acme:form-submit test ="${command == 'show'}" code="administrator.challenge.form.button.delete" action="/administrator/challenge/delete"/>
	<acme:form-submit test ="${command == 'update'}" code="administrator.challenge.form.button.update" action="/administrator/challenge/update"/>
	<acme:form-submit test ="${command == 'delete'}" code="administrator.challenge.form.button.delete" action="/administrator/challenge/delete"/>
	<acme:form-submit test ="${command == 'create'}" code="administrator.challenge.form.button.create" action="/administrator/challenge/create"/>
	<acme:form-return code="administrator.challenge.form.label.button.return"/>
</acme:form>