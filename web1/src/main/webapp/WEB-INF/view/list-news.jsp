<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>

<html>

<head>
<title>List News</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
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

			<!-- loop over and print our news -->
			<c:forEach var="tempNews" items="${news}">

				<!-- construct an "view" link with news id -->
				<c:url var="viewLink" value="/news/showNewsDetails">
					<c:param name="newsId" value="${tempNews.id}" />
				</c:url>
				<!-- construct an "update" link with news id -->

				<c:url var="updateLink" value="/news/showFormForUpdate">
					<c:param name="newsId" value="${tempNews.id}" />
				</c:url>

				<!-- construct an "delete" link with customer id -->
				<c:url var="deleteLink" value="/news/delete">
					<c:param name="newsId" value="${tempNews.id}" />
				</c:url>



				<div class="box1">
					<h3>${tempNews.newsTitle}</h3>
				</div>

				<div class="box2">
					<h3>
						<ins>
							<fmt:formatDate value="${tempNews.newsDate}" pattern="dd-MM-yyyy" />
						</ins>

					</h3>
				</div>
				<br>
				<br>
				<br>
				<p align="left">${tempNews.brief}</p>
				<p align="right">

					<a href="${viewLink}"><spring:message code="label.view" /></a> <a href="${updateLink}"><spring:message code="label.edit" /></a> <a
						href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false"><spring:message code="label.delete" /></a>
				</p>
				<br>
				<br>
			</c:forEach>

		</div>
	</div>

	<div id="footer">
		<p align="center"><spring:message code="label.copyright" /></p>
	</div>

</body>

</html>











