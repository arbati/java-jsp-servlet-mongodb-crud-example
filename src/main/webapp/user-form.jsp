<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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

				<a href="<%=request.getContextPath()%>/list"
					class="btn btn-secondary"><i class="fa fa-list"></i> ALL USERS</a>

				<hr>

				<h1>USER INFO</h1>

				<c:if test="${user != null }">
					<form action="store-update" method="post" class="row g-3">
				</c:if>

				<c:if test="${user == null }">
					<form action="store" method="post" class="row g-3">
				</c:if>


				<div class="col-12">
					<label class="form-label">Name</label> <input type="hidden"
						name="_id" value="<c:out value='${user.id}' />" /> <input
						type="text" class="form-control" name="name"
						placeholder="first and last name"
						value="<c:out value='${user.name}' />" />
					<div class="text-danger"></div>
				</div>

				<div class="col-12">
					<label class="form-label">Email</label> <input type="text"
						class="form-control" name="email" placeholder="Email"
						value="<c:out value='${user.email}' />" />
					<div class="text-danger"></div>
				</div>



				<div class="col-6">


					<label class="form-label">Country</label> <input type="text"
						class="form-control" name="country" placeholder="Country"
						value="<c:out value='${user.country}' />" />
					<div class="text-danger"></div>

				</div>

				<div class="col-12">


					<button type="submit" class="btn btn-primary">
						<i class="fa fa-send"></i> Send data
					</button>

				</div>


				</form>

			</div>
			<div class="col"></div>

		</div>

	</div>





</body>
</html>