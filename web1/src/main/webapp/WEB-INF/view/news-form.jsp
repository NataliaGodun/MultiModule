<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>

<head>
	<title>Save News</title>

	<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
	
	<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/news-form.css"/>" />
	
	
</head>

<body>
	<div class="content">

		<div id="wrapper">
			<div id="header">

				<spring:message code="label.header" />
				<span style="float: right"> <a href="?lang=en">en</a> | <a
					href="?lang=ru">ru</a>
				</span>

			</div>
		</div>

		<div class="menu">

			<h3><spring:message code="label.news" /></h3>
			<ul>
				<li><a href="list"><spring:message code="label.newsList" /></a></li>
				<li><a href="showFormForAdd"><spring:message code="label.addNews" /></a></li>
			</ul>
		</div>

		<div class="center">

		<form:form action="saveNews" modelAttribute="news" method="POST">

			<!-- need to associate this data with news id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><spring:message code="label.newsTitle" /></td>
						<td><form:input path="newsTitle" /></td>
					</tr>
				
					<tr>
						<td><spring:message code="label.newsDate" /></td>
						<td><form:input path="newsDate"/></td>
					</tr>

					<tr>
						<td><spring:message code="label.newsBrief" /></td>
						<td><form:input path="brief" /></td>
					</tr>
					
					<tr>
						<td><spring:message code="label.newsContent" /></td>
						<td><form:input path="content" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="<spring:message code="label.save" />" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		
	
	</div>
	</div>
	<div id="footer">
		<p align="center"><spring:message code="label.copyright" /></p>
	</div>
</body>

</html>










