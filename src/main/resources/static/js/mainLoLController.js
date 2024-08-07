app.controller("mainLoLController",function($scope,$http){
    $scope.searchChamp = "";
    $scope.searchMatchup = "";
    $scope.games = [
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Taliyah'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Corki'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Yone"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Vladimir'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Zed'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Twisted Fate'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'LeBlanc'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Zed'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Garen'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Xerath'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Jayce'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Yasuo'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Ryze'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Cassiopeia'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Yone'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Viktor'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Malzahar'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Kassadin'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'LeBlanc'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Tristana'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Zed'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Yasuo'},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Malzahar'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Vex'},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Syndra"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Brand"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Zed', matchup: "Yasuo"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Aurelion Sol"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Yone"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Zed', matchup: "Fizz"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Zed', matchup: "Tristana"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Garen"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Ahri"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Syndra"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Twisted Fate"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Vex"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Annie"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Anivia"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Vex"},
      {issue: 'Victoire', lane: 'Adc', champion: 'Ezreal', matchup: "Miss Fortune"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Vel'Koz"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Vladimir"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Ahri"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Yone"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Viktor"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "LeBlanc"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Viktor"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Hwei"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Viktor"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Xerath"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Fizz"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Ahri"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Corki"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Yasuo"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Anivia'},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Tristana"},
      {issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Zed"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Ekko"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Riven"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Naafiri"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Tristana"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "LeBlanc"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Malphite"},
      {issue: 'Victoire', lane: 'Mid', champion: "Katarina", matchup: "Akali"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Katarina"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "Lissandra"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "Talon"},
      {issue: 'Victoire', lane: 'Mid', champion: "Katarina", matchup: "Annie"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Akshan"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Quinn"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Kayle"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Hwei"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "Viktor"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Brand"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Yasuo"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Naafiri"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Galio"},
      {issue: 'Victoire', lane: 'Mid', champion: "Katarina", matchup: "Tristana"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Tristana"},
      {issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Vex"},
      {issue: 'Victoire', lane: 'Mid', champion: "Katarina", matchup: "Quiyana"},
      {issue: 'Victoire', lane: 'Mid', champion: "Vel'Koz", matchup: "Caitlyn"},
      {issue: 'Victoire', lane: 'Mid', champion: "Katarina", matchup: "Vladimir"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Katarina"},
      {issue: 'Défaite', lane: 'Adc', champion: 'Ezreal', matchup: "Kog'Maw"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "Twisted Fate"},
      {issue: 'Défaite', lane: 'Mid', champion: "Vel'Koz", matchup: "Katarina"},
      {issue: 'Défaite', lane: 'Mid', champion: "Katarina", matchup: "Kassadin"}
    ];
    $scope.rowContainsChampion = function(row) {
          if (!$scope.searchChamp) {
              return true; // No filter if search value is empty
          }
          return ('' + row.champion).indexOf($scope.searchChamp) !== -1;
      };
    $scope.rowContainsMatchup = function(row) {
          if (!$scope.searchMatchup) {
              return true; // No filter if search value is empty
          }
          return ('' + row.matchup).indexOf($scope.searchMatchup) !== -1;
      };
    $scope.sendData = function() {	
		$http.post("http://localhost:8080/main_data", $scope.games)
			.then(function(response) {
				console.log("Data sent successfully");
				$scope.getTotalWinrate();
			}, function(error) {
				console.error("Error sending data", error);
			});
	};
	
	$scope.getTotalWinrate = function() {  
	    $http.get('http://localhost:8080/winrate')
	    	.then(function(response) {
				console.log("Total winrate data fetched successfully");
	            $scope.nbGames = response.data.nbGames;
	            $scope.totalWinrate = response.data.totalWinrate;
	        })
	        .catch(function(error) {
	            console.error('Erreur lors de la récupération des données:', error);
	        });
	 }
	
	$scope.sendData();
  });