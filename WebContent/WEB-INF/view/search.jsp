<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<c:set value="${pageContext.request.contextPath}" var="path" />

<html>
<head>
<meta charset="UTF-8">
<title>Notebook</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="background: #F0FFFFF;">

	<div class="container">
		<div class="pull-left" style="margin-top: 10px;">
			<h2>
				<a href="${path}" style="text-decoration: none; color: #16a085;">Online
					Notebook</a>
			</h2>
		</div>

		<div class="pull-right" style="margin-top: 10px;">
			<button class="btn btn-warning">User</button>

			<button class="btn btn-info">Login</button>

			<button class="btn btn-success" style="margin-left: 5px;">Sign
				up</button>
		</div>

		<div class="pull-right"
			style="margin-top: 130px; margin-right: -80px;">
			<form:form action="${path}/note/search" method="post">
				<input name="title" class="form-group" type="text"
					size="30" placeholder="Title" />
				<input class="btn btn-success" type="submit" name="searchBtn"
					value="Search" />
			</form:form>
		</div>

		<div class="pull-right"
			style="margin-top: 130px; margin-right: -410px;">

			<a href="${path}/note/create" class="btn btn-info"> <span
				class="glyphicon glyphicon-plus" style="margin-bottom: 3px;">
					CREATE</span>
			</a>
		</div>

		<table class="table table-bordered"
			style="margin-top: 170px; margin-bottom: 100px;">
			<tr style="background-color: #16a085; color: #fff">
				<td>ID</td>
				<td>Title</td>
				<td>Content</td>
				<td>Date</td>
				<td>Open</td>
				<td>Edit</td>
				<td>Remove</td>
			</tr>
			<c:forEach items="${search}" var="note">
				<tr>
					<td>${note.id}</td>
					<td>${note.title}</td>
					<td>${note.note}</td>
					<td>${note.date}</td>

					<td><a href="${path}/note/read/${note.id}"
						style="width: 100%;" class="btn btn-info">Open</a></td>

					<td><a href="${path}/note/update/${note.id}"
						style="width: 100%;" class="btn btn-success">Edit</a></td>

					<td><a href="${path}/note/remove/${note.id}"
						style="width: 100%;" class="btn btn-danger">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>
