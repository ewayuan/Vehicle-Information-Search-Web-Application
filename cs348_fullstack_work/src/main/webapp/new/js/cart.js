angular.module("myApp")
.controller("CartController", ['$scope', '$http', '$rootScope', '$window', 
	function($scope, $http, $rootScope, $window) {
		console.log("CartController");

		$scope.itemList = $rootScope.selectedItems;

		$scope.deleteItem = function() {
			var selectedID = [];
			var formData = new FormData();
	    	$.each($("input:checked"), function(){
                selectedID.push($(this).val());
                formData.append("vid", $(this).val());
            });

            for(var i = 0; i < selectedID.length; i++) {
            	var item = selectedID[i];
            	var index = $scope.itemList.indexOf(item);
            	$scope.itemList.splice(index);
            }

            formData.append("uid", $rootScope.userID);
            var request = new XMLHttpRequest();
			request.open("POST", "/uidDelCids/");
			request.send(formData);
            $rootScope.selectedItems = $scope.itemList;
            //$window.location.href = 'new/index.html/#cart';
	    }
}]);
