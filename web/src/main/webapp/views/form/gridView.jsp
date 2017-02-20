<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>form view</title>
<link href="<c:url value="/resources/grid.css" />" rel="stylesheet"	type="text/css" />
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.min.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.mask.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.mask.money.js" />"></script>
<script type="text/javascript"	src="<c:url value="/resources/jqueryui/1.8/jquery.ui.numeric.js" />"></script>

</head>
<body>
	<div id="content">
		<h2>Students</h2>

		<div class="header">
			<h2>Schools Members</h2>
			<c:if test="${not empty students}">
				<table class="tableLess">
				<tbody>
					<tr class="headerTable">
						<td>NAME</td>
						<td>AGE</td>
						<td>PHONE</td>
						<td>SALARY</td>
					</tr>
				</tbody>
					
					<c:forEach items="${students}" var="student">
					<tr>
						<td class="name"><span class="holderName">${student.name}</span></td>
						<td class="age">${student.age}</td>
						<td class="phone">${student.phone}</td>
						<td class="salary">${student.salary}</td>
					</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>
