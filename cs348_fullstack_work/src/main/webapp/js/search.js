/*var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
  $routeProvider
  .when("/", {
    templateUrl : "main.htm"
  })
  .when("/london", {
    templateUrl : "london.htm",
    controller : "londonCtrl"
  })
  .when("/paris", {
    templateUrl : "paris.htm",
    controller : "parisCtrl"
  });
});
app.controller("londonCtrl", function ($scope) {
  $scope.msg = "I love London";
});
app.controller("parisCtrl", function ($scope) {
  $scope.msg = "I love Paris";
});
*/

var app = angular.module("SearchManagement", []);

//Controller Part
app/*.config(function($routeProvider) {
    $routeProvider
    .when("/vehicleInfoSystem/search", {
        templateUrl: "search.html",
        controller: "SearchController"
    });
})*/.controller("SearchController", function($scope, $http) {
    $scope.modelList = ["All"];
    $scope.yearList = ["All"];
    $scope.makeList = ["All"];

    $scope.searchCriteria = {};


    $scope.selectMakeWarning = true;
    //"/getAllFuelConsumptions"
    /*$scope.showWarning = function() {
        $(".select-make-warning").show(10,1);
        $(".select-make-warning").fadeTo(10,0);
    }*/

    getMakeList();

    

    /*$scope.getModelList = function() {
        $http({
            method : "GET",
            url : 'search/getAllModels',
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            $scope.customers = response[0];
        }, function errorCallback(response) {
            console.log("ERROR");
        });
    }*/

    

    function getMakeList() {
        $http({
            method : "GET",
            url : '/getAllMake',
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            var rawMakes = response.data;
            for (var i = 0; i < rawMakes.length; i++) {
                $scope.makeList.push(rawMakes[i].make);
            }
        }, function errorCallback(response) {
            console.log("ERROR: getMakeList");
        });
    }

    $scope.getSearchCriteria = function() {
        var e = document.getElementById("model");
        $scope.selecedModel = e.options[e.selectedIndex].value;
        e = document.getElementById("year");
        $scope.selecedYear = e.options[e.selectedIndex].value;
        e = document.getElementById("make");
        $scope.selecedMake = e.options[e.selectedIndex].value;
        e = document.getElementById("priceFrom");
        $scope.selecedPrice[0] = e.options[e.selectedIndex].value;
        e = document.getElementById("priceTo");
        $scope.selecedPrice[1] = e.options[e.selectedIndex].value;

        $scope.searchCriteria.model = $scope.selecedModel;
        $scope.searchCriteria.year = $scope.selecedYear;
        $scope.searchCriteria.make = $scope.selecedMake;
        $scope.searchCriteria.priceFrom = $scope.selecedPrice[0];
        $scope.searchCriteria.priceTo = $scope.selecedPrice[1];
    }
  
});