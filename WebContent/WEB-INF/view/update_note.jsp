<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value="${pageContext.request.contextPath}" var="path" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Note</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${path}/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h2 style="text-align: center;">Update Note</h2>

	<form:form method="post" action="${path}/note/update">
		<div class="form-group updateForm">
			<form:hidden path="id"/>	

			<form:input path="title" type="text" class="updateNoteTitle"
				size="50%" placeholder="Title" />
			<br />

			<div class="col-md-8 col-md-offset-2">
				<form:textarea path="note" rows="20" cols="100"
					class="updateNoteBody" placeholder="Note"></form:textarea>
				<br />


				<div class="createButtons">
					<input class="btn btn-info" type="submit" name="updateSaveBtn"
						value="Save" />
					<input class="btn btn-danger" type="submit"
						name="cancel" value="Back To Home" />
				</div>
			</div>
		</div>
	</form:form>

</body>
</html>
