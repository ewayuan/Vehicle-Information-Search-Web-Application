//var app = angular.module("SearchManagement", []);

//Controller Part
angular.module("myApp").controller("SearchController", ['$scope', '$http', '$rootScope', '$window', function($scope, $http, $rootScope, $window) {
    $scope.searchBar = true;
    $scope.searchResult = false;

    $scope.modelList = ["All"];
    $scope.yearList = ["All"];
    $scope.makeList = ["All"];
    $scope.priceList = [0, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000];

    $scope.searchCriteria = {};

    $scope.selectMakeWarning = false;
    $scope.selectYearWarning = false;
    $scope.selectModelWarning = false;

    getYearList();
    getModelList();
    getMakeList();

    function getYearList() {
        $http({
            method : "GET",
            url : '/allUniqueYears',
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            var rawYears = response.data;
            for (var i = 0; i < rawYears.length; i++) {
                $scope.yearList.push(rawYears[i]);
            }
        }, function errorCallback(response) {
            console.log("ERROR: getYearList");
        })
    }

    function getModelList() {
        $http({
            method : "GET",
            url : '/allUniqueModels',
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            var rawModels = response.data;
            for (var i = 0; i < rawModels.length; i++) {
                $scope.modelList.push(rawModels[i]);
            }
        }, function errorCallback(response) {
            console.log("ERROR: getModelList");
        });
    }

    

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
                $scope.makeList.push(rawMakes[i].makee);
            }
        }, function errorCallback(response) {
            console.log("ERROR: getMakeList");
        });
    }

    function submitSeachRequest() {
        $http({
            method : "GET",
            url : '/searchBar/' + $scope.searchCriteria.model + '/' 
                                + $scope.searchCriteria.year + '/' 
                                + $scope.searchCriteria.make,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            var resultList = response.data;
            $scope.resultList = resultList;
            $scope.searchBar = false;
            $scope.searchResult = true;
            /*$rootScope.$broadcast('sendSearchResult', resultList);
            window.location.pathname = '/html/results.html';*/
        }, function errorCallback(response) {
            console.log("ERROR: submitSeachRequest");
        });
    }

    $scope.getSearchCriteria = function() {
        //reset
        $scope.resetData();

        var e = document.getElementById("model");
        $scope.selecedModel = e.options[e.selectedIndex].value.trim();
        if ($scope.selecedModel == "") $scope.selectModelWarning = true;

        e = document.getElementById("year");
        $scope.selecedYear = e.options[e.selectedIndex].value.trim();
        if ($scope.selecedYear == "") $scope.selectYearWarning = true;

        e = document.getElementById("make");
        $scope.selecedMake = e.options[e.selectedIndex].value.trim();
        if ($scope.selecedMake == "") $scope.selectMakeWarning = true;

        /** Price is not available now - March 8th **/
        $scope.selecedPrice = [];
        e = document.getElementById("priceFrom");
        $scope.selecedPrice[0] = (e.options[e.selectedIndex].value.trim() == "") ? null : e.options[e.selectedIndex].value.trim();
        
        e = document.getElementById("priceTo");
        $scope.selecedPrice[1] = (e.options[e.selectedIndex].value.trim() == "") ? null : e.options[e.selectedIndex].value.trim();

        $scope.searchCriteria.model = $scope.selecedModel;
        $scope.searchCriteria.year = $scope.selecedYear;
        $scope.searchCriteria.make = $scope.selecedMake;
        $scope.searchCriteria.priceFrom = $scope.selecedPrice[0];
        $scope.searchCriteria.priceTo = $scope.selecedPrice[1];

        submitSeachRequest();
    }

    $scope.resetData = function() {
        $scope.selectMakeWarning = false;
        $scope.selectYearWarning = false;
        $scope.selectModelWarning = false;
    }

    /*$rootScope.resultList = [
                            {
                                "vid": 1,
                                "year": "2019",
                                "mid": 1,
                                "model": "M4 Cabriolet",
                                "comb_cons": 12.7
                            },
                            {
                                "vid": 2,
                                "year": "2019",
                                "mid": 1,
                                "model": "M4 Cabriolet Competition",
                                "comb_cons": 12.7
                            },
                            {
                                "vid": 3,
                                "year": "2019",
                                "mid": 1,
                                "model": "M4 Coupe",
                                "comb_cons": 12.6
                            },
                            {
                                "vid": 4,
                                "year": "2019",
                                "mid": 1,
                                "model": "M4 CS",
                                "comb_cons": 12.6
                            },
                            {
                                "vid": 5,
                                "year": "2019",
                                "mid": 1,
                                "model": "X3 M40i",
                                "comb_cons": 8.7
                            }
                        ];*/
  
}]);