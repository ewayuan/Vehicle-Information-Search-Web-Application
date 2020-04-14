angular.module("myApp")
.controller("LogInController", ['$scope', '$rootScope', '$http', '$window', 
	function($scope, $rootScope, $http, $window) {
    console.log("LogInController");
    console.log($rootScope.userID);

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
            if (response.data != -1) {
            	$scope.logInWarning = false;
                $rootScope.userID = response.data;
                getCartInfo($rootScope.userID);
                getUserInfo($rootScope.userID);
				$window.location.href = 'new/index.html/#search';
            } else {
            	$scope.logInWarning = true;
            }
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
    }

    function getCartInfo(uid) {
        $http({
            method : "GET",
            url : '/uidFindVehicleInfos/' + uid,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            $rootScope.selectedItems = response.data;
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
    }

    function getUserInfo(uid) {
        $http({
            method : "GET",
            url : '/getUser/' + uid,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            $rootScope.userInfo = response.data;
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
    /*"uid": 4,
    "username": "x558li",
    "password": "nancy",
    "usertype": "Buyer"*/
    }

}]);

 