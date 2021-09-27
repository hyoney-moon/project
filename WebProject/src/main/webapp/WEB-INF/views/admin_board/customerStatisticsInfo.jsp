<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700&display=swap" rel="stylesheet">
<style>
* {
font-family: 'Nanum Gothic', sans-serif;
}
#static {
	text-align: center;
}
h {
	font-weight: bold;
}
</style>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
window.onload = function(){

const labels = [
	  '1월',
	  '2월',
	  '3월',
	  '4월',
	  '5월',
	  '6월',
	  '7월',
	  '8월',
	  '9월',
	];
	const data = {
	  labels: labels,
	  datasets: [{
	    label: '월별 누적 회원수(명)',
	    backgroundColor: '#704de4',
	    borderColor: '#704de4',
	    data: ${custNumList},
	  }]
	};
	
	const config = {
			  type: 'bar',
			  data: data,
			  options: {}
			};

  var custCountChart = new Chart(
    document.getElementById('custCountChart'),
    config
  );
  
  // 누적 게시글 수
  
  const boardCountlabels = [
	  '1월',
	  '2월',
	  '3월',
	  '4월',
	  '5월',
	  '6월',
	  '7월',
	  '8월',
	  '9월',
	];
	const boardCountData = {
	  labels: boardCountlabels,
	  datasets: [{
	    label: '누적 게시글 수(개)',
	    backgroundColor: '#f1c40f',
	    borderColor: '#f1c40f',
	    data: ${boardCountList},
	  }]
	};
	
	const boardCountconfig = {
			  type: 'bar',
			  data: boardCountData,
			  options: {}
			};

  var boardCountChart = new Chart(
    document.getElementById('boardCountChart'),
    boardCountconfig
  );
  
  // 일반회원 연령 분포
  const percentAge = ${custAgeList};
  const percentAge10 = percentAge[0] / (percentAge[0] + percentAge[1] + percentAge[2] + percentAge[3] + percentAge[4]) * 100;
  const percentAge20 = percentAge[1] / (percentAge[0] + percentAge[1] + percentAge[2] + percentAge[3] + percentAge[4]) * 100;
  const percentAge30 = percentAge[2] / (percentAge[0] + percentAge[1] + percentAge[2] + percentAge[3] + percentAge[4]) * 100;
  const percentAge40 = percentAge[3] / (percentAge[0] + percentAge[1] + percentAge[2] + percentAge[3] + percentAge[4]) * 100;
  const percentAge50 = percentAge[4] / (percentAge[0] + percentAge[1] + percentAge[2] + percentAge[3] + percentAge[4]) * 100;
  const custAgelabels = [
	  '10대',
	  '20대',
	  '30대',
	  '40대',
	  '50대',
	];
	const custAgeData = {
	  labels: custAgelabels,
	  datasets: [{
	    label: '회원 연령 분포',
	    backgroundColor: 
	    	//'rgb(255, 99, 132)',
	    	["#2ecc71",
	        "#3498db",
	        "#95a5a6",
	        "#9b59b6",
	        "#f1c40f",
	        "#e74c3c",
	        "#34495e"],
	    //borderColor: 'rgb(255, 99, 132)',
	    data: [
	    	percentAge10,
	    	percentAge20,
	    	percentAge30,
	    	percentAge40,
	    	percentAge50,
	    ],
	  }]
	};
	
	const custAgeconfig = {
			  type: 'pie',
			  data: custAgeData,
			  options: {
				  title: {
				        display: true,
				        text: '회원 연령 분포',
				      },
			  }
			};

  var custAgeChart = new Chart(
    document.getElementById('custAgeChart'),
    custAgeconfig
  );
  
  // 성비
  const percentMW = ${genderList};
  
  const percentM = percentMW[0] / (percentMW[0] + percentMW[1]) * 100;
  const percentW = percentMW[1] / (percentMW[0] + percentMW[1]) * 100; 
  
  const genderlabels = [
	  '남자',
	  '여자',
	];
	const genderData = {
	  labels: genderlabels,
	  datasets: [{
	    label: '성비',
	    backgroundColor:[
	    	"#0984e3",
	        "#d63031",
	        ],
	    	//'rgb(255, 99, 132)',
	    // borderColor: Object.values(Utils.CHART_COLORS),
	    data: [percentM, percentW],
	    	//${genderList},
	  }]
	};
	
	const genderconfig = {
			  type: 'pie',
			  data: genderData,
			  options: {}
			};

  var custAgeChart = new Chart(
    document.getElementById('genderChart'),
    genderconfig
  );
}
</script>

</head>
<body style="background-color: #f6f6f6;">
<header>
		<%@ include file="../publicCSS/adminheader.jsp"%>
</header>

<h1 style="text-align: center; margin-top: 100px; margin-bottom: 20px;">회원 정보 통계</h1>
<div id="static">
<!-- <h3>월별 누적 회원수(명)</h3> -->
<div style="position: static; margin: auto; height:20vh; width:40vw; margin-bottom: 30px;">
  <canvas id="custCountChart"></canvas>
</div>
<br><br><br><br><br><br><br>
<!-- <h3>누적 게시글 수(개)</h3> -->
<div style="position: static; margin: auto; height:20vh; width:40vw">
  <canvas id="boardCountChart"></canvas>
</div>
<br><br><br><br><br><br><br>
<!-- <h2>총 매출액(원)</h2> -->
<div style="position: static; margin: auto; height:20vh; width:40vw">
  <canvas id="totalRevenueChart"></canvas>
</div>
<h4>회원 연령(%)</h4>
<div style="position: static; margin: auto; height:20vh; width:40vw">
  <canvas id="custAgeChart"></canvas>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<h4>회원 성비(%)</h4>
<div style="position: static; margin: auto; height:20vh; width:40vw">
  <canvas id="genderChart"></canvas>
</div>
</div>
</body>

</html>