app.controller('colorController', function($scope, $window) {
    // Charger la couleur de fond depuis le localStorage
    $scope.bgColor = $window.localStorage.getItem('bgColor') || '#FFFFFF';    //blanc par défaut

    $scope.changeColor = function(newColor) {
        $scope.bgColor = newColor;
        // Sauvegarder la couleur de fond dans le localStorage
        $window.localStorage.setItem('bgColor', newColor);
    };

    // Écouter l'événement de stockage pour synchroniser la couleur de fond entre les fenêtres
    $window.addEventListener('storage', function(event) {
        if (event.key === 'bgColor') {
            $scope.$apply(function() {
                $scope.bgColor = event.newValue;
            });
        }
    });
});