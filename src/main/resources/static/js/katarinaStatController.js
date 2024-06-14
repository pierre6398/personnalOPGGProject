app.controller("katarinaStatController", function($scope, $http) {
	$scope.getKataWinrate = function() {
	    $http.get('http://localhost:8080/Katarina/winrate')
	    	.then(function(response) {
				console.log("Data fetched successfully");
	            $scope.value = response.data.toFixed(1);
	            $scope.getKataWinrates();
	        })
	        .catch(function(error) {
	            console.error('Erreur lors de la récupération des données:', error);
	        });
    }
      
   $scope.getKataWinrates = function() {  
	    $http.get('http://localhost:8080/Katarina/winrates')
	    	.then(function(response) {
				console.log("Data fetched successfully");
	            $scope.chartData = response.data;
	            
	            createBarChart($scope.chartData, $scope.value)
	        })
	        .catch(function(error) {
	            console.error('Erreur lors de la récupération des données:', error);
	        });
	 }

	function createBarChart(data, value){
		var ctx = document.getElementById('myChart').getContext('2d');
        var chart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: Object.keys(data),
                datasets: [{
                    label: 'Values',
                    data: Object.values(data),
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
				},
				plugins: {
	                annotation: {
	                    annotations: {
	                        line1: {
	                            type: 'line',
	                            yMin: value,
	                            yMax: value,
	                            borderColor: 'red',
	                            borderWidth: 2,
	                            label: {
	                                content: value + '% winrate',
	                                enabled: true,
	                                position: 'right'
	                            }
	                        }
	                    }
                	}
                }
            }
        });
    }
    $scope.getKataWinrate();
});