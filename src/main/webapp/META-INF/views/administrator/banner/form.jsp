<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-url code="administrator.banner.form.label.urlPicture" path="urlPicture"/>
	<acme:form-textarea code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.urlTarget" path="urlTarget"/>
	
	<acme:form-submit test ="${command == 'show'}" code="administrator.banner.form.button.update" action="/administrator/banner/update"/>
	<acme:form-submit test ="${command == 'show'}" code="administrator.banner.form.button.delete" action="/administrator/banner/delete"/>
	<acme:form-submit test ="${command == 'create'}" code="administrator.banner.form.button.create" action="/administrator/banner/create"/>
	<acme:form-submit test ="${command == 'update'}" code="administrator.banner.form.button.update" action="/administrator/banner/update"/>
	<acme:form-submit test ="${command == 'delete'}" code="administrator.banner.form.button.delete" action="/administrator/banner/delete"/>
	
	<acme:form-return code="administrator.banner.form.label.button.return"/>
</acme:form>