<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All users</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>
<body class="bg-info">
	<div class="container bg-light"
		style="margin-top: 20px; padding: 30px;">
		<div class="row">
			<div class="col"></div>
			<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">

				<div class="d-md-flex justify-content-md-end">
					<a href="<%=request.getContextPath()%>/new" class="btn btn-primary">
						<i class="fa fa-plus"></i> New user
					</a>
				</div>
				<hr>

				<h1>ALL USERS</h1>

				<div class="row table-responsive bg-light">
					<table class="table table-striped" style="">
						<thead>
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Email</td>
								<td>Country</td>
								<td></td>
								<td></td>
							</tr>
						</thead>
						<tbody>



							<c:forEach var="user" items="${users}">

								<tr>
									<td><c:out value="${user.id}" /></td>
									<td><c:out value="${user.name}" /></td>
									<td><c:out value="${user.email}" /></td>
									<td><c:out value="${user.country}" /></td>
									<td><a href="delete?_id=${user.id}"
										onclick="return confirm('Are you sure to delete the user?');">
											<i class="fa fa-trash fa-lg"></i>
									</a></td>
									<td><a href="update?_id=${user.id}"><i
											class="fa fa-pencil fa-lg"></i></a></td>
								</tr>

							</c:forEach>

						</tbody>

					</table>

				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>
</html>