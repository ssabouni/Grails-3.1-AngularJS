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

    SearchFactory.list({action:'categories'}, function(response){
        vm.categories = response;
    });

    vm.selectedCategories = [];

    vm.dubbed = undefined;
    vm.signed= undefined;
    vm.media= undefined;
    vm.advancedSearch = function(){
        SearchFactory.list({action:'advanced', dubbed: vm.dubbed, signed: vm.signed, media:vm.media}, function(response){
            vm.results = response;
            vm.hello="HELLO";
        });
    };

    vm.showAdvanced=false;
    vm.optionsText="Advanced Search";

    vm.showForm = function(){
        if (vm.showAdvanced === true){
            vm.showAdvanced = false;
            vm.optionsText = "Advanced Search"
        }
        else if(vm.showAdvanced === false){
            vm.showAdvanced = true;
            vm.optionsText = "Hide Options"
        }
    };


}