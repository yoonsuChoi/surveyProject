<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
	crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<c:choose>
			<c:when test="${not empty list }">
				<table class="table table-hover">
					<thead class="table-info">
						<tr>
							<th scope="col">설문 제목</th>
							<th scope="col">글쓴이</th>
							<th scope="col">시작일</th>
							<th scope="col">종료일</th>
							<th scope="col">참여수</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="list">
							<tr>
								<th scope="row"><a href='survey/surveyResult?sv_id=${list.sv_id}' style="color: #212529"> ${list.sv_title }</th>
								<td>${list.sv_writer }</td>
								<td>${list.sv_startdate }</td>
								<td>${list.sv_enddate }</td>
								<td>${list.sv_count }</td>
								<td>${list.sv_hits }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${empty list }">
			<div class="row">
				<div class="col-sm-12">
					<div class="card">
						<div class="card-body"  style="text-align: center;" >
							<h5  class="card-title">참여한 설문이 없습니다.</h5>
							<p class="card-text">설문에 참여해보세요!!</p>
							<button type="button" class="btn btn-secondary btn-lg btn-block">설문하러 가기</button>
						</div>
					</div>
				</div>
			</div>
			</c:when>

		</c:choose>


	</div>
</body>
</html>