//= wrapped
//= require /angular/angular
//= require /myapp/core/core
//= require /myapp/search/myapp.search

angular.module("myapp", [
    "ngRoute",
    "myapp.core",
    "myapp.search"
]);
