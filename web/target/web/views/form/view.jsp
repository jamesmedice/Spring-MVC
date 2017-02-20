<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>form view</title>
<link href="<c:url value="/resources/form.css" />" rel="stylesheet"	type="text/css" />
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.min.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.mask.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.mask.money.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.numeric.js" />"></script>

</head>
<body>
	<div id="content">
		<h2>Students Form</h2>
		<form:form id="form" method="post" modelAttribute="student"
			cssClass="cleanform">
			<div class="header">
				<h2>School Members</h2>
				<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>
					<div id="person" class="success">
						<div>Person: ${studentSql.name}, ${studentSql.age}, ${studentSql.phone}</div> 
					</div>
				</c:if>
				<s:bind path="*">
					<c:if test="${status.error}">
						<div id="message" class="error">Please fill the form correctly</div>
					</c:if>
				</s:bind>
			</div>
			<fieldset>
				<legend>Student Personal Information:</legend>
				<form:label path="name">
		  			Name <form:errors path="name" cssClass="error" />
				</form:label>
				<form:input path="name" />

				<form:label path="age">
		  			Age <form:errors path="age" cssClass="error" />
				</form:label>
				<form:input path="age" />

				<form:label path="birthDate">
		  			Birth Date (yyyy-mm-dd) <form:errors path="birthDate"
						cssClass="error" />
				</form:label>
				<form:input path="birthDate" id="birthDate" />

				<form:label path="phone">
		  			Phone ((##) ####-####) <form:errors path="phone" cssClass="error" />
				</form:label>
				<form:input path="phone" id="phone" />

				<form:label path="salary">
		  			salary ( $#.##) <form:errors path="salary" cssClass="error" />
				</form:label>
				<form:input path="salary" id="salary" />
			</fieldset>
			<p>
				<button type="submit">Submit</button>
			</p>
		</form:form>		
		<script type="text/javascript">
			$(document).ready(
					function() {
						$("#form").submit(
								function() {
									$.post($(this).attr("action"), $(this)
											.serialize(), function(html) {
										$("#content").replaceWith(html);
										$('html, body').animate(
												{
													scrollTop : $("#message")
															.offset().top
												}, 500);
									});
									return false;
								});
						
					});
			
			$("#birthDate").datepicker({ dateFormat: 'yy-mm-dd' });
			$("#age").numeric();
			$("#phone").mask('(99) 9999-9999');
			$("#salary").maskMoney({ allowNegative: false, thousands:'', decimal:'.', affixesStay: false}); 
		</script>
	</div>
</body>
</html>
