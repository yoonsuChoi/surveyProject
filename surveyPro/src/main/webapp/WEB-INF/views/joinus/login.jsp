<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<link href="http://getbootstrap.com/docs/4.1/examples/floating-labels/floating-labels.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

    <form class="form-signin" method="POST">
      <div class="text-center mb-4">
        <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">울윤수와 거북이들</h1>
        <p>로그인을 하시오</p> 
      </div>

      <div class="form-label-group">
        <input type="text" name="m_id" id="m_id" class="form-control" placeholder="ID" required autofocus>
        <label for="inputEmail">ID</label>
      </div>
		<span style="color: red">${error}</span>
      <div class="form-label-group">
        <input type="password" name="m_pw" id="m_pw" class="form-control" placeholder="Password" required>
        <label for="inputPassword">Password</label>
      </div>
	
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      <a href="http://localhost/web/joinus/join" class="btn btn-lg btn-primary btn-block" type="button">Register</a>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 로그인 페이지</p>
    </form>
    
  </body>
</html>S