<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
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
	    data: ${custNumList},
	  }]
	};
	
	const config = {
			  type: 'bar',
			  data: data,
			  options: {}
			};

  var myChart = new Chart(
    document.getElementById('myChart'),
    config
  );
}
</script>

</head>
<body>

<div>
  <canvas id="myChart"></canvas>
</div>

</body>
</html>