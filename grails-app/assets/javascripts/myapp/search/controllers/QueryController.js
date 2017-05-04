/**
 * Created by ssabouni on 04/05/2017.
 */

angular.module("myapp.search").controller("QueryController", QueryController);

function QueryController(SearchFactory){
    var vm = this;
    SearchFactory.get({action:'help'}, function(response){
        vm.results = response;
        vm.hello = "HELLO";

    });

}