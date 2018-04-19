
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/inc/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.3.0/Chart.min.js"></script>
<title>${title }- 설문 응답</title>
<style>
*, *::before, *::after {
   -webkit-box-sizing: border-box;
   -moz-box-sizing: border-box;
   box-sizing: border-box
}

body, table, select, option, textarea, input {
   font-family: "Titillium Web"
}

html {
   display: -webkit-flex;
   display: flex;
   height: 100%;
   -webkit-align-items: center;
   align-items: center;
   -webkit-justify-content: center;
   justify-content: center;
   text-align: center
}

body {
   width: 90%;
   max-width: 50em;
   line-height: 1.5;
   display: inline-block;
   text-align: left
}

p {
   margin: 0 0 2em
}

.u-align-center {
   position: relative;
   top: 50%;
   -webkit-transform: translateY(-50%);
   transform: translateY(-50%)
}

.Form {
   padding: 2em;
   background-color: rgba(0, 0, 0, 0.02);
   box-shadow: 0 0 5px rgba(0, 0, 0, 0.1)
}

@media only screen and (min-width:50em) {
   .Form {
      padding: 5em
   }
}

.Form-section {
   margin-right: -1em;
   margin-bottom: 1.5em
}

.Form-section+.Form-section {
   padding-top: 1em;
   border-top: 1px dotted rgba(0, 0, 0, 0.1)
}

.Form-title {
   display: block;
   font-weight: bold;
   margin-bottom: .5em
}

.Form-label, .Form-label--tick {
   display: block
}

.Form-label--tick {
   position: relative;
   display: inline-block;
   margin-left: 1em
}

.Form-label-radio, .Form-label-checkbox {
   position: absolute;
   z-index: -1;
   width: 1px;
   height: 1px;
   opacity: 0;
   overflow: hidden
}

.Form-label-radio+.Form-label-text, .Form-label-checkbox+.Form-label-text
   {
   cursor: pointer;
   margin-right: 1em
}

.Form-label-radio+.Form-label-text::before, .Form-label-checkbox+.Form-label-text::before
   {
   font-size: .875em;
   display: inline-block;
   width: 1.75em;
   height: 1.75em;
   line-height: 1.5;
   border: 1px solid #ccc;
   margin-right: .25em;
   content: "\00a0";
   color: white;
   background-clip: padding-box;
   background-color: white;
   text-align: center
}

.Form-label-radio+.Form-label-text:hover::before, .Form-label-checkbox+.Form-label-text:hover::before
   {
   border-color: black !important;
   box-shadow: 0 0 0 0 black !important
}

.Form-label-radio:checked+.Form-label-text::before, .Form-label-checkbox:checked+.Form-label-text::before
   {
   background-color: black;
   border-color: black;
   box-shadow: 0 0 0 0 black;
   font-family: FontAwesome;
   content: "\f00c"
}

.Form-label-radio:focus+.Form-label-text::before, .Form-label-checkbox:focus+.Form-label-text::before,
   .Form-label-radio:active+.Form-label-text::before, .Form-label-checkbox:active+.Form-label-text::before
   {
   border-color: #3bb8ff;
   box-shadow: 0 0 2px 0 rgba(0, 135, 212, 0.2)
}

.Form-label-radio+.Form-label-text::before {
   border-radius: 100%
}
</style>
</head>

<body>

   <div style="margin-left: 15%; margin-top: 10%; font-size: 25px;">
      <span><b> 타이틀 </b></span>
   </div>
   <br>
   <div style="margin-left: 15%;">
	
	  <div>
	    <canvas id="myChart"></canvas>
	  </div>



   </div>


<br />
<br />
<br />
	<button id="btn_goList">go List</button>
</body>
<script>
	$(function(){
		$("#btn_goList").click(function(){
			location.href="/survey/surveylist";
		});
	
	});


</script>


<script>
var labels = new Array();
var data = new Array();
<c:forEach items="${choices}" var="result">
	var json = new Object();
	labels.push("${result.list_content}");
	data.push("${result.percent}");
</c:forEach>

// 차트 색상

var letters = ["rgb(255, 99, 132)","rgb(255, 159, 64)","rgb(255, 205, 86)","rgb(75, 192, 192)","rgb(54, 162, 235)","rgb(153, 102, 255)","rgb(201, 203, 207)"];

// backgroundColor
var color = new Array();

for (var i = 0; i < labels.length; i++) {
	color.push(letters[i]);
}

// 차트그리기
var ctx = document.getElementById('myChart').getContext('2d');
var myPieChart = new Chart(ctx,{
    type: 'pie',
    data: {
    	labels: labels,
	    datasets: [{
	    	
	    	data: data,
	    	backgroundColor: color
	        
	    }
	  ] 	
    },
    options:{
    	animation:{
    		animationScale:true
    	}
    }

});

</script>
</html>