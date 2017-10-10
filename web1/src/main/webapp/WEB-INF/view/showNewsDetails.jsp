<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Details News</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/newsDetails.css"/>" />


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



			<c:url var="updateLink" value="/news/showFormForUpdate">
				<c:param name="newsId" value="${tempNews.id}" />
			</c:url>

			<!-- construct an "delete" link with customer id -->
			<c:url var="deleteLink" value="/news/delete">
				<c:param name="newsId" value="${tempNews.id}" />
			</c:url>


			<div class="block1"><spring:message code="label.newsTitle" /></div>
			<div class="block2">${tempNews.newsTitle}</div>
			<br /> <br />

			<div class="block1"><spring:message code="label.newsDate" /></div>
			<div class="block2">
				<fmt:formatDate value="${tempNews.newsDate}" pattern="dd-MM-yyyy" />
			</div>
			<br /> <br />
			
			<div class="block1"><spring:message code="label.newsBrief" /></div>
			<div class="block2">${tempNews.brief}</div>
			<br /> <br />
			
			<div class="block1"><spring:message code="label.newsContent" /></div>
			<div class="block2">${tempNews.content}</div>
			<br /><br />

			<p align="right">

				<a href="${updateLink}"><spring:message code="label.edit" /></a> <a href="${deleteLink}"
					onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false"><spring:message code="label.delete" /></a>
			</p>


		</div>
	</div>
	<div id="footer">
		<p align="center"><spring:message code="label.copyright" /></p>
	</div>
</body>

</html>
