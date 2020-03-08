var app = angular.module("LogInManagement", []);

app.controller("LogInController", function($scope, $http, $rootScope) {
	$scope.logInWarning = false;
	$scope.wrongUserWarning = false;
	$scope.user = {};

	$scope.logInUser = function() {
		$scope.user.username = $scope.inputUsername;
		$scope.user.password = $scope.inputPassword;
		checkUserExists($scope.user); //check -> login	
	}

	function checkUserExists(user) {
		$http({
            method : "GET",
            url : '/checkUsernameExist/' + user.username,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            if (response.data == true) {
            	$scope.wrongUserWarning = false;
            	logInUser(user);
            } else {
            	$scope.wrongUserWarning = true;
            }
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
	}

	function logInUser(user) {
        $http({
            method : "GET",
            url : '/checkUserValid/' + user.username + '/' + user.password,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            if (response.data == true) {
            	$scope.logInWarning = false;
				window.location.pathname = '/html/search.html';
            } else {
            	$scope.logInWarning = true;
            }
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
    }
});