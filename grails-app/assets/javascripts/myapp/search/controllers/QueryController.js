/**
 * Created by ssabouni on 04/05/2017.
 */

angular.module("myapp.search").controller("QueryController", QueryController);

function QueryController(SearchFactory){
    var vm = this;
    vm.keywords = undefined;
    vm.search = function(){
        SearchFactory.list({action:'search', keywords:vm.keywords}, function(response){
            vm.results = response;
            vm.hello="HELLO";
        });
    };

    vm.arrayToString = function(string){
        return string.join(", ");
    };


}