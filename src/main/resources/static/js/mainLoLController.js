app.controller("mainLoLController",function($scope,$http){
    $scope.searchChamp = "";
    $scope.searchMatchup = "";
    $scope.games = [
      {id: "1", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Taliyah'},
      {id: "2", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {id: "3", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Corki'},
      {id: "4", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: "Cho'Gath"},
      {id: "5", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: "Yone"},
      {id: "6", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Vladimir'},
      {id: "7", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Zed'},
      {id: "8", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {id: "9", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Twisted Fate'},
      {id: "10", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'LeBlanc'},
      {id: "11", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Zed'},
      {id: "12", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Garen'},
      {id: "13", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {id: "14", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {id: "15", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Akali'},
      {id: "16", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Xerath'},
      {id: "17", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Jayce'},
      {id: "18", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Aurelion Sol'},
      {id: "19", issue: 'Victoire', lane: 'Mid', champion: 'Katarina', matchup: 'Yasuo'},
      {id: "20", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Ryze'},
      {id: "21", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Cassiopeia'},
      {id: "22", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Yone'},
      {id: "23", issue: 'Défaite', lane: 'Mid', champion: 'Katarina', matchup: 'Viktor'}
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
			}, function(error) {
				console.error("Error sending data", error);
			});
	};
	
	$scope.sendData();
  });