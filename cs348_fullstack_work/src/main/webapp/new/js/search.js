angular.module("myApp")
.controller("SearchController", ['$scope', '$http', '$rootScope', '$window', 
	function($scope, $http, $rootScope, $window) {
		console.log("SearchController");

		if (!$rootScope.modelList) {
			$rootScope.modelList = ["All"];;
		} 
		$scope.modelList = $rootScope.modelList;
	
		$scope.searchBar = true;
    	$scope.searchResult = false;
    	$scope.userID = $rootScope.userID;

	    $scope.searchBar = true;
	    $scope.searchResult = false;

	    $scope.makeList = ["All"];
	    $scope.yearList = [];
	    $scope.priceList = [0, 10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000];

	    $scope.searchCriteria = {};

	    $scope.selectMakeWarning = false;
	    $scope.selectYearWarning = false;
	    $scope.selectModelWarning = false;

	    getYearList();
	    getMakeList();
	    getModelList();
	    //getModelList($scope.searchCriteria.make);


	    /*$("#make").change(function() {
	        var val = $(this).val();
	        $scope.getModelList(val.trim());
	        location.reload();
	        //$("#model").html("<option ng-repeat='model in modelList'><div>{{model}}</div></option>");
	    });*/

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

	  /*$scope.getModelList = function(make) {
	        $http({
	            method : "GET",
	            url : '/makeGetModelsInfo/' + make,
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then(function successCallback(response) {
	            var rawModels = response.data;
	            for (var i = 0; i < rawModels.length; i++) {
	                $scope.modelList.push(rawModels[i]);
	            }
	            $rootScope.modelList = $scope.modelList;
	        }, function errorCallback(response) {
	            console.log("ERROR: getModelList");
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

	    $scope.addToCart = function() {
	    	var selectedID = [];
	    	var selectedItems = [];
	    	$.each($("input:checked"), function(){
                selectedID.push($(this).val());
            });

            for(var i = 0; i < $scope.resultList.length; i++) {
            	var car = $scope.resultList[i];

            	var n = selectedID.includes(car.vid.toString());
            	if (n) {
            		selectedItems.push(car);
            	}
            }

            $rootScope.selectedItems = $rootScope.selectedItems.concat(selectedItems) ;
            $window.location.href = 'new/index.html/#cart';
	    }

}]);
