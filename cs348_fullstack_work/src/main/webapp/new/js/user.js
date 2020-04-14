angular.module("myApp")
.controller("UserController", ['$scope', '$rootScope', '$http', '$window', 
	function($scope, $rootScope, $http, $window) {
		$scope.changePwd = true;
		$scope.changeUsername = false;
		$scope.userID = $rootScope.userID;
		$scope.userInfo = $rootScope.userInfo;

		$scope.changeType = function (type) {
			if (type =="pwd") {
				$scope.changePwd = true;
				$scope.changeUsername = false;
			} else if (type =="username") {
				$scope.changePwd = false;
				$scope.changeUsername = true;
			}
		}

		$scope.changeUserInfo = function (type, changeTo) {
			var update = "";
			if (type =="pwd") {
				update = "updatePassword" ;
			} else if (type =="username") {
				update = "updateUsername";
			}
			var uid = $rootScope.userID;

			$http({
	            method : "POST",
	            url : update + "/" + uid + "/" + changeTo,
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then(function successCallback(response) {
	            console.log("Success");
	        }, function errorCallback(response) {
	            console.log("ERROR: logInUser");
        	});
	    }

	    $scope.deleteUser = function () {
	    	$http({
	            method : "DELETE",
	            url : /deleteUser/ + $rootScope.userID,
	            headers : {
	                'Content-Type' : 'application/json'
	            }
	        }).then(function successCallback(response) {
	            console.log("Delete" + $rootScope.userID + "Success");
	        }, function errorCallback(response) {
	            console.log("ERROR: deleteUser");
        	});
	    }
			
}]);