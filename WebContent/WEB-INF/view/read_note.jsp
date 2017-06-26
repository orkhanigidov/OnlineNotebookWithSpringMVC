<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath}" var="path" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read Note</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2 style="text-align: center;">Read Note</h2>

	<form:form action="${path}/note/read" method="post">
		<div class="form-group readForm">
			<p class="readNoteTitle">${note.title}</p>

			<div class="col-md-8 col-md-offset-2">
				<p class="readNoteBody">${note.note}</p>
				<br />

				<div class="readButtons">
					<input class="btn btn-danger" type="submit" name="cancel"
						value="Back To Home" />
				</div>
				 
			</div>
		</div>
	</form:form>

</body>
</html>
