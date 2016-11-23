<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="#" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-fruit">New Fruit</a></li>
					<li><a href="all-fruits">All Fruits</a></li>
					<li><a href="/">Task</a></li>
					<li><a href="evidence">Evidence</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Fruit Manager</h1>
				</div>
			</div>
		</c:when>
		
		
		<c:when test="${mode=='MODE_FRUITS'}">
			<div class="container text-center" id="fruitsDiv">
				<h3>My Fruits</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Color</th>
								<th>Date created</th>
								<th>Quantity</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fruit" items="${fruits}">
								<tr>
									<td>${fruit.id_fruit}</td>
									<td>${fruit.name_fruit}</td>
									<td>${fruit.color}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${fruit.dateArrive}" /></td>
									<td>${fruit.quantity}</td>
									<td><a href="update-fruit?id_fruit=${fruit.id_fruit}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-fruit?id_fruit=${fruit.id_fruit}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NEW_FRUIT' || mode=='MODE_UPDATE_FRUIT'}">
			<div class="container text-center">
				<h3>Manage Fruit</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-fruit">
					<input type="hidden" name="id_fruit" value="${fruit.id_fruit}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name Fruit:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name_fruit"
								value="${fruit.name_fruit}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Color:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="color"
								value="${fruit.color}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Quantity:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="quantity"
								value="${fruit.quantity}" />
						</div>
					</div>

					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
						
	</c:choose>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
</body>
</html>