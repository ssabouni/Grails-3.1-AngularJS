/**
 * Created by ssabouni on 04/05/2017.
 */

angular.module("myapp.search").controller("QueryController", QueryController);

function QueryController(SearchFactory){
    var vm = this;
    vm.keywords = undefined;

    vm.showResults=false;
    vm.search = function(){
        SearchFactory.list({action:'search', keywords:vm.keywords}, function(response){
            vm.results = response;
            vm.resultsLength= vm.results.length;
            vm.hello="HELLO";

            vm.showResults=true;
        });
    };

    vm.arrayToString = function(string){
        return string.join(", ");
    };

    vm.selectedMasterbrand=undefined;
    SearchFactory.list({action:'masterbrand'}, function(response){
        vm.masterbrands = response;
        vm.hello="HELLO";
    });

 /*   SearchFactory.list({action:'categories'}, function(response){
        vm.categories = response;
    });*/

    vm.selectedCategories = [];

    vm.dubbed = undefined;
    vm.signed= undefined;
    vm.media= undefined;
    vm.startDate = undefined;
    vm.endDate = undefined;

    vm.advancedSearch = function(){
        SearchFactory.list({action:'advanced', dubbed: vm.dubbed, signed: vm.signed, media:vm.media,
            brand: vm.brand, keywords:vm.keywords, clip:vm.clip}, function(response){
            vm.results = response;
            vm.resultsLength= vm.results.length;
            vm.hello="HELLO";

            vm.showResults=true;
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

    // convert clip to yes if true, no if false
    vm.covertClip = function(){
    }




}