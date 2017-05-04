package myapp

class TestController {
	//static responseFormats = ['json', 'xml']
    def testService

    def search(String keywords){
        def results = testService.testMethod(keywords)
        respond results, model:[resultsCount: results.size()]
    }

    def bbc(){
        render "Hello"
    }

    def index(){
        render "Hello World"
    }
}
