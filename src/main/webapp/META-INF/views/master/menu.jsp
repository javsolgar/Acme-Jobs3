<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.announcement.list" action="/anonymous/announcement/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.investorsrecords.list" action="/anonymous/investorsrecords/list"/>
			<acme:menu-suboption code="master.menu.anonymous.topinvestorsrecords.list" action="/anonymous/topinvestorsrecords/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.companyrecord.list" action="/anonymous/companyrecord/list"/>
			<acme:menu-suboption code="master.menu.anonymous.topcompanyrecord.list" action="/anonymous/topcompanyrecord/list"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.announcement.list" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.challenge.list" action="/authenticated/challenge/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.request.list" action="/authenticated/request/list"/>
			<acme:menu-suboption code="master.menu.authenticated.offer.list" action="/authenticated/offers/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.authenticated.investorsrecord.list" action="/authenticated/investorsrecords/list"/>
			<acme:menu-suboption code="master.menu.authenticated.companyrecord.list" action="/authenticated/companyrecord/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
			<acme:menu-suboption code="master.menu.administrator.configuration.list" action="/administrator/configuration/show" />
			<acme:menu-suboption code="master.menu.administrator.dashboard.show" action="/administrator/dashboard/show" />
			<acme:menu-suboption code="master.menu.administrator.banner.list" action="/administrator/banner/list" />
			<acme:menu-suboption code="master.menu.administrator.banner.create" action="/administrator/banner/create" />	
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement.list" action="/administrator/announcement/list"/>
			<acme:menu-suboption code="master.menu.administrator.announcement.create" action="/administrator/announcement/create"/>
			<acme:menu-suboption code="master.menu.administrator.challenge.list" action="/administrator/challenge/list"/>
			<acme:menu-suboption code="master.menu.administrator.challenge.create" action="/administrator/challenge/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.investorsrecord.list" action="/administrator/investorsrecords/list"/>
			<acme:menu-suboption code="master.menu.administrator.investorsrecord.create" action="/administrator/investorsrecords/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.configuration.list" action="/administrator/configuration/show" />
			<acme:menu-suboption code="master.menu.administrator.dashboard.show" action="/administrator/dashboard/show" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.comercialbanner.list" action="/administrator/comercialbanner/list" />
			<acme:menu-suboption code="master.menu.administrator.comercialbanner.create" action="/administrator/comercialbanner/create" />	
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.noncomercialbanner.list" action="/administrator/noncomercialbanner/list" />
			<acme:menu-suboption code="master.menu.administrator.noncomercialbanner.create" action="/administrator/noncomercialbanner/create" />	
			<acme:menu-separator/>

			<acme:menu-suboption code="master.menu.administrator.companyrecord.list" action="/administrator/companyrecord/list" />
			<acme:menu-suboption code="master.menu.administrator.companyrecord.create" action="/administrator/companyrecord/create" />			

			
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.provider.requestList" action="/provider/request/list"/>
			<acme:menu-suboption code="master.menu.provider.requestCreate" action="/provider/request/create"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.consumer.requestList" action="/authenticated/request/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.consumer.OfferList" action="/consumer/offers/list"/>
			<acme:menu-suboption code="master.menu.consumer.OfferCreate" action="/consumer/offers/create"/>
		</acme:menu-option>
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>