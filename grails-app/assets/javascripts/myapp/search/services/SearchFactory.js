/**
 * Created by ssabouni on 04/05/2017.
 */
//= wrapped

angular
    .module("myapp.search")
    .factory("SearchFactory", SearchFactory);

function SearchFactory(DomainServiceFactory) {
    return DomainServiceFactory('/test/:action',{action:'@action'},
        {"show": {method: "GET"}},
        {"save": {method: "POST"}},
        {"delete": {method: "DELETE"}}
    );
}