var myApp = angular.module("myApp",['ngRoute', 'angularCSS'])

.config(function($routeProvider){
     $routeProvider.
     when('/search',{
          templateUrl: '/new/html/search.html',
          controller:'SearchController',
          css: "new/css/search.css"
     }).
     when('/logIn',{
          templateUrl: '/new/html/logIn.html',
          controller:'LogInController',
          css: "new/css/logIn.css"
     }).
     when('/cart',{
          templateUrl: '/new/html/cart.html',
          controller:'CartController',
          css: "new/css/cart.css"
     }).
     when('/signUp', {
          templateUrl: '/new/html/signUp.html',
          controller: 'SignUpController',
          css: "new/css/signUp.css"
     }).
     when('/user', {
          templateUrl: '/new/html/user.html',
          controller: 'UserController',
          css: "new/css/user.css"
     }).
     /*when('/logIn',{
      templateUrl: '../html/logIn.html',
      controller:'LogInController'
     }).

     $routeProvider.
     when("/NewStudent",{
          templateUrl : "add_student.html",
          controller: "AddStudentController"
     }).
      when("/DisplayStudent", {
          templateUrl: "show_student.html",
               controller: "ViewStudentController"
     }).*/
     otherwise ({
          redirectTo: '/search'
     })
});
