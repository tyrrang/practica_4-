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
					<li><a href="new-evidence">New Evidence</a></li>
					<li><a href="all-evidences">All Evideces</a></li>
					<li><a href="/">Task</a></li>
					<li><a href="fruit">Fruit</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
	
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Evidence Manager</h1>
				</div>
			</div>
		</c:when>		
	
		<c:when test="${mode=='MODE_EVIDENCES'}">
			<div class="container text-center" id="evidenceDiv">
				<h3>My Evidence</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Code</th>
								<th>Association Id</th>
								<th>Dbxref Id</th>
								<th>Seq Acc</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="evidence" items="${evidences}">
								<tr>
									<td>${evidence.id}</td>
									<td>${evidence.code}</td>
									<td>${evidence.association_id}</td>
									<td>${evidence.dbxref_id}</td>
									<td>${evidence.seq_acc}</td>
									<td><a href="update-evidence?id=${evidence.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-evidence?id=${evidence.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW_EVIDENCE' || mode=='MODE_UPDATE_EVIDENCE'}">
			<div class="container text-center">
				<h3>Manage Evidence</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-evidence">
					<input type="hidden" name="id" value="${evidence.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Code:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="code"
								value="${evidence.code}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Association Id:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="association_id"
								value="${evidence.association_id}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Dbxref Id:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="dbxref_id"
								value="${evidence.dbxref_id}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Seq Acc:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="seq_acc"
								value="${evidence.seq_acc}" />
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