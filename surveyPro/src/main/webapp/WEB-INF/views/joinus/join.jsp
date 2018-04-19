<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<link href="http://getbootstrap.com/docs/4.1/examples/floating-labels/floating-labels.css" rel="stylesheet">
<link href="http://getbootstrap.com/docs/4.1/examples/checkout/form-validation.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>

<body class="bg-light">
    <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>Register</h2>
      </div>
      <div class="row">
        <div class="col-md order-md-1">
          <h4 class="mb-3">Billing address</h4>
          <form class="needs-validation" method="post" id="join" >
            <div class="row">
              <div class="col-md-4 mb-3">
                <label for="firstName">이름</label>
                <input type="text" class="form-control" id="firstName" value="" name="m_name" required>
                 <span id="idwarning" style="color: red"></span>
              </div>
              <div class="col-md-4 mb-3">
                <label for="나이">나이</label>
                <select class="custom-select d-block w-100" id="age" name="m_age" required >
				<c:forEach var="age" begin="10" end="80">
                  <option value="${age }">${age }</option>
                 </c:forEach>
                </select>
              </div>
              <div class="col-md-2">
             <label for="성별">성별</label>
            <div class="d-block">
                <input id="man" name="m_gender" type="radio" value="남" style="width: 20px" checked required> 남자
                <input id="female" name="m_gender" type="radio" value="여" style="width: 20px" required>여자
            </div>
            </div>
           </div>
            <div class="mb-3">
              <label for="username">아이디</label>
              <div class="input-group">
                <input type="text" name="m_id" class="form-control" id="userID" placeholder="Username"required>
                <div class="input-group-prepend">
                  <span class="input-group-text" id="idcheck">중복성 검사</span>
                </div>
              </div>
                <div id="warning" style="color: red"></div>
            </div>
             <div class="row">
            <div class="col-md-6 mb-3">
              <label for="비밀번호">비밀번호 </label>
              <input type="password" class="form-control" id="pwd" name="m_pwd" placeholder="4글자 이상 입력하세요."required>
            </div>

            <div class="col-md-6 mb-3">
              <label for="비밀번호">비밀번호 확인</label>
              <input type="password" class="form-control" id="pwdcheck" placeholder="4글자 이상 입력하세요." required>
            </div>
            <span id="warning" style="color: red"></span>
            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" id="submit" type="submit">회원가입</button>
          </form>
        </div>
      </div>
    </div>
    
  </body>
  <script type="text/javascript">
  $(function () {
	 $('#pwdcheck,#pwd').keyup(function () {
		 pwdcheck = 2;
		  var pwd = $("input#pwd").val();
		  var check = $("input#pwdcheck").val();
		  if (pwd != "" && check != "") {
			  if (check != pwd){
				  $("span#warning").text("비밀번호가 일치하지 않습니다.");
				  pwdcheck = 0;
			  }
			  else{
				  $("span#warning").text("");
				  pwdcheck = 1;
			  }
			}
	});//비밀번호 확인 
	 
	$("#idcheck").click(function () {
		idcheck = 2;
		console.log( $("#userID").val() );
		$.ajax({
			type:'post',
			url:'http://localhost/web/joinus/check',
			data: {
				"m_id":$("#userID").val()
			},
			success:function(count){
				if(count==0) {
					$("div#warning").text("사용가능한 ID입니다.");
					idcheck = 1;
				}else {
					$("div#warning").text("이미 사용 중인 ID입니다.");
					idcheck = 0;
				}
			}
		});//ajax
	});
	
	$("#submit").click(function (e) {
		if (pwdcheck!=1 || idcheck!=1) {
			if ($("div#warning").text()=='') {
			 	$("div#warning").text("ID 중복 검사를 해주세요");
				
			}
			 e.preventDefault();
		}else {
			$("#join").submit();
		}
	});
	
});
  	
  
  </script>
</html>