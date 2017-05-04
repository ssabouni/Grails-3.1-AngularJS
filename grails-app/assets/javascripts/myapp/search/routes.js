/**
 * Created by ssabouni on 04/05/2017.
 */
//= wrapped

angular.module("myapp.search")
    .config(function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: "/myapp/search/search.html",
            controller: "QueryController as ctrl"
        })
    });