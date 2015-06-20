<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Resources</title>
<jsp:include page="../page/head.jsp" />
</head>
<body>
	<jsp:include page="../page/header.jsp" />



	<div class="section section-breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>Resources</h1>
					<a data-toggle="modal" class="btn" href="#addKnbase">Add
						knowledgebase</a>

				</div>
			</div>
		</div>
	</div>



	<div class="container">
		<h2>knowledge base</h2>



		<c:forEach items="${base }" var="kbase">
			<div class="col-md-3 col-sm-6">
				<div class="service-wrapper">

					<h3>
						<script type="text/javascript">
							var Regex = /\d[_].*$/g;
							var Regex2 = /[^\d^_].*/g;

							var fileName1 = Regex
									.exec("${kbase.value.getPath()}");
							var fileName = Regex2.exec(fileName1);
							document.write(fileName)
						</script>
					</h3>
					<img src="resources/img/fileicon/${kbase.key }.png"
						onerror="this.src='resources/img/fileicon/other.png'"
						class="img-rounded" width="128" height="128" alt="file">
					<p>${home.value.getDescription()}</p>
					<p>Rating: ${home.key.getRating()}</p>
					<p>
						<a
							href="<c:url value="/downloadFile?file=${kbase.value.getPath()}"/>"
							class="btn">Download</a>
					</p>
					<p>
						<a
							href="<c:url value="/KnowledgeBaseServlet?action=delete&deleteFile=${kbase.value.getPath()}&id_kbase=${kbase.value.getId()}"/>"
							class="btn">Delete</a>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>
	<!-- End Pricing Table -->

	<div id="addKnbase" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Add kbase</h4>
				</div>
				<div class="modal-body">
					<form action="KnowledgeBaseServlet?action=new" method="post"
						enctype="multipart/form-data" role="form" role="form">

						<div class="form-group">
							<label for="login-password"><i class="icon-lock"></i> <b>File</b></label>
							<input name="file" class="form-control" type="file"
								required="required" placeholder="">
						</div>

						<div class="form-group">
							<input class="form-control" name="cours_id" type="hidden"
								id="cours_id" value="${course_id}">
						</div>
						<div class="form-group">

							<button type="submit" class="btn pull-right">Add</button>
							<div class="clearfix"></div>
						</div>
					</form>
				</div>

			</div>
		</div>

	</div>
	<jsp:include page="../page/footer.jsp" />
</body>
</html>