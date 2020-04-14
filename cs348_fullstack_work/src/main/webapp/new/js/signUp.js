angular.module("myApp")
.controller("SignUpController", ['$scope', '$rootScope', '$http', '$window', 
	function($scope, $rootScope, $http, $window) {

	$scope.usernameWarning = false;
	$scope.passwordWarning = false;
	
	$scope.user = {};
	$scope.roleType = "Buyer";

	$scope.getUserInfo = function() {
		//check passwords match
		if ($scope.user.password !== $scope.confirmPassword) {
			$scope.passwordWarning = true;
		}

		//get user role type;
		$scope.checkRadioBtn();
		$scope.user.roleType = $scope.roleType;

		//sent repquest
		if ($scope.usernameWarning != true && $scope.passwordWarning != true) {
			$scope.submitUser_backend($scope.user);
		}

		//set back values
		$scope.usernameWarning = false;
		$scope.passwordWarning = false;
		$scope.user = {};
		$scope.roleType = "Buyer";
	}

	$scope.checkRadioBtn = function() {
		if (document.getElementById("buyerRadio").checked == true) {
			$scope.roleType = "Buyer";
		} else if (document.getElementById("manufacturerRadio").checked == true) {
			$scope.roleType = "Manufacturer";
		}
	}

	$scope.submitUser = function() {
		checkUserExists($scope.user.username);
		//$scope.submitUser_backend($scope.user);
	}


	function checkUserExists(username) {
		$http({
            method : "GET",
            url : '/checkUsernameExist/' + username,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            if (response.data == false) {
            	$scope.wrongUserWarning = false;
            	$scope.getUserInfo();
            } else {
            	$scope.wrongUserWarning = true;
            }
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
	}

	$scope.submitUser_backend = function() {
         
        var method = "";
        var url = "";

        method = "POST";
        url = '/addUser';

        $http({
            method : method,
            url : url,
            params : { usertype: $scope.user.roleType,
            		   username: $scope.user.username,
            		   password: $scope.user.password},
            //data : angular.toJson(user),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
        	alert("User " + response.data.username + " has been created successfully!");
        	$window.location.href = 'new/index.html/#logIn';
		    console.log("New User Created Successfully.");
	  	}, function errorCallback(response) {
	     	console.log("Failed to Create New User.");
	  	});
    };

		
}]);