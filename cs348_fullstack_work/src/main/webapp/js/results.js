//var app = angular.module("ResultManagement", []);

//app.
angular.module("myApp").controller("ResultController", ['$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {

	$scope.resultList = $rootScope.resultList;

	$rootScope.$on('sendSearchResult', function (event, resultList) {
		$scope.resultList = resultList;
	});
}]);