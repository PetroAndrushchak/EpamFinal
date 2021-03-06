<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" uri="/WEB-INF/teg.tld"%>
<div class="mainmenu-wrapper">
	<div class="container">
		<div class="menuextras">
			<div class="extras">
				<ul>
					<li>
						<div class="btn-group">
							<button data-toggle="dropdown"
								class="btn btn-primary btn-xs dropdown-toggle">
								<t:i18n id="header.language" />
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">

								<c:forEach items="${languageList}" var="lang">
									<li role="menuitem"><a
										href="<c:url value="/lenguage?language=${lang.getLanguage() }&country=${lang.getCountry()}" />"><img
											src="resources/img/flags/${lang.getImage()}"
											onerror="this.src='resources/img/flags/up.png'"
											alt="${lang.getName()}">
										<c:out value="${lang.getName()}" /> </a></li>

								</c:forEach>

							</ul>
						</div>
					</li>
					<!--Приклад силки для завантаження файлу  -->
					<%-- 	<li><a href="<c:url value="/downloadFile?file=photo\1892596744_author.png" />">Download Link</a></li>
 --%>


					<c:if test="${user!=null}">
						<li class="shopping-cart-items"><a
							href="<c:url value="/UserServlet" />"><i 
								class="glyphicon glyphicon-user icon-white"><b id = "userNameHeader"> <c:out
											value="${user.getName()}" />
								</b></i></a></li>
						<li class="shopping-cart-items"><a
							href="<c:url value="/exit" />"><i
								class="glyphicon glyphicon-log-out icon-white"><b> <t:i18n
											id="header.exit" /></b></i></a></li>
					</c:if>
					<c:if test="${user==null }">
						<li class="shopping-cart-items"><a
							href="<c:url value="/login" />"><i
								class="glyphicon glyphicon-lock icon-white"><b> <t:i18n
											id="header.login" /></b></i></a></li>

					</c:if>
				</ul>
			</div>

		</div>

		<nav id="mainmenu" class="mainmenu">
			<ul>
				<li class="logo-wrapper"><a href="<c:url value="home" />"><img
						src="resources/img/jquery.png"
						alt="Multipurpose Twitter Bootstrap Template"></a></li>
				<li id="home" class="active"><a href="<c:url value="/home" />"><t:i18n
							id="header.home" /></a></li>
				<li id="courses"><a href="<c:url value="/CourseServlet" />"><t:i18n
							id="header.courses" /></a></li>
				<li id="articles"><a href="<c:url value="/ArticleServlet" />"><t:i18n
							id="header.article" /></a></li>

				<li id="faq"><a href="<c:url value="/FaqServlet" />">FAQ</a></li>

				<li id="contacts"><a href="<c:url value="/Contact" />"><t:i18n
							id="header.contact" /></a></li>


			</ul>
		</nav>

	</div>

</div>


