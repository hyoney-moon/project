<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
#static {
	text-align: center;
}
</style>
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

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
	    backgroundColor: 'rgb(255, 99, 132)',
	    borderColor: 'rgb(255, 99, 132)',
	    data: ${hostNumList},
	  }]
	};
	
	const config = {
			  type: 'bar',
			  data: data,
			  options: {}
			};
  var hostCountChart = new Chart(
    document.getElementById('hostCountChart'),
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
	    backgroundColor: 'rgb(255, 99, 132)',
	    borderColor: 'rgb(255, 99, 132)',
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
	    	"#2ecc71",
	        "#3498db",
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
  var hostAgeChart = new Chart(
    document.getElementById('genderChart'),
    genderconfig
  );
}
</script>

</head>
<body>
	<div id="static">
		<h2>월별 누적 호스트 회원수(명)</h2>
		<div
			style="position: relative; margin: auto; height: 20vh; width: 40vw">
			<canvas id="hostCountChart"></canvas>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<h2>누적 게시글 수(개)</h2>
		<div
			style="position: relative; margin: auto; height: 20vh; width: 40vw">
			<canvas id="boardCountChart"></canvas>
		</div>
		<!-- <h2>총 매출액(원)</h2> -->
		<div
			style="position: relative; margin: auto; height: 20vh; width: 40vw">
			<canvas id="totalRevenueChart"></canvas>
		</div>
		<h2>회원 성비(%)</h2>
		<div
			style="position: relative; margin: auto; height: 20vh; width: 40vw">
			<canvas id="genderChart"></canvas>
		</div>
	</div>
</body>
</html>