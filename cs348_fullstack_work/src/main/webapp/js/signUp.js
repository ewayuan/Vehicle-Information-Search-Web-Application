
var app = angular.module("SignUpManagement", []);

app.controller("SignUpController", function($scope, $http) {
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
	}


	function checkUserExists(username) {
		$http({
            method : "GET",
            url : '/checkUsernameExist/' + username,
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
            if (response.data == true) {
            	$scope.wrongUserWarning = false;
            	$scope.getUserInfo();
            } else {
            	$scope.wrongUserWarning = true;
            }
        }, function errorCallback(response) {
            console.log("ERROR: logInUser");
        });
	}

	$scope.submitUser_backend = function(user) {
         
        var method = "";
        var url = "";

        method = "POST";
        url = 'user/addNewUser';

        $http({
            method : method,
            url : url,
            data : angular.toJson(user),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(function successCallback(response) {
		    console.log("New User Created Successfully.");
	  	}, function errorCallback(response) {
	     	console.log("Failed to Create New User.");
	  	});
    };

		
});