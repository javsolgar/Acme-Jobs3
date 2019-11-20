<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<acme:form readonly="true">

<acme:form readonly="true">
	<acme:form-integer code="administrator.dashboard.form.label.totalAnnouncement" path="totalAnnouncement" />
	<acme:form-integer code="administrator.dashboard.form.label.totalInvestorsRecord" path="totalInvestorsRecord" />	
	<acme:form-integer code="administrator.dashboard.form.label.totalCompanyRecords" path="totalCompanyRecords" />
	<acme:form-double code="administrator.dashboard.form.label.minRewardRequest" path="minRewardRequest" />
	<acme:form-double code="administrator.dashboard.form.label.maxRewardRequest" path="maxRewardRequest" />	
	<acme:form-double code="administrator.dashboard.form.label.minRewardOffers" path="minRewardOffers" />
	<acme:form-double code="administrator.dashboard.form.label.maxRewardOffers" path="maxRewardOffers"/>
	<acme:form-double code="administrator.dashboard.form.label.mediaRequest" path="mediaRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.mediaOffer" path="mediaOffer"/>
	<acme:form-double code="administrator.dashboard.form.label.stdevRequest" path="stdevRequest"/>
	<acme:form-double code="administrator.dashboard.form.label.stdevOffer" path="stdevOffer"/>
	
</acme:form>

<!--  -->	

	<h2><acme:message code="administrator.dashboard.form.title.chartCompanys"/></h2>
	<div><canvas id="canvas"></canvas></div>
	<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels	:	[
					<jstl:forEach var="item" items="${sectorsOfCompanys}">
					"${item}",
					</jstl:forEach>
				],
				datasets	:	[ 
					{
						data : [
							<jstl:forEach var="item" items="${companysBySector}">
							"${item}",
							</jstl:forEach>
							
						]
					
				}
					]
		
		
	};
	
	var options =	{
			scales	:	{
				yAxes	:	[
					{
						ticks	:	{
							suggestedMin	:	0.0,
							suggestedMax	:	20.0
						}
					}
				]
			},
			legend	:	{
				display : false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementById("canvas");
	context = canvas.getContext("2d");
	new Chart(context, {
		type	:	"bar",
		data	:	data,
		options	:	options
	});
});
	
	
	</script>
	<h2><acme:message code="administrator.dashboard.form.title.chartInverstors"/></h2>
	<div><canvas id="canvas2"></canvas></div>
	<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				labels	:	[
					<jstl:forEach var="item" items="${sectorsOfInverstors}">
					"${item}",
					</jstl:forEach>
				],
				datasets	:	[ 
					{
						data : [
							<jstl:forEach var="item" items="${inverstorsBySector}">
							${item},
							</jstl:forEach>
							
						]
					
				}
					]
		
		
	};
	
	var options =	{
			scales	:	{
				yAxes	:	[
					{
						ticks	:	{
							suggestedMin	:	0.0,
							suggestedMax	:	20.0
						}
					}
				]
			},
			legend	:	{
				display : false
			}
	};
	
	var canvas, context;
	
	canvas = document.getElementById("canvas2");
	context = canvas.getContext("2d");
	new Chart(context, {
		type	:	"bar",
		data	:	data,
		options	:	options
	});
});
	
	
	</script>
	
	<acme:form-return code="administrator.configuration.form.label.button.return"/>
</acme:form>