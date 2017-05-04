package myapp

class TestController {
	//static responseFormats = ['json', 'xml']
    def testService

    def help(){
        def result = testService.testMethod()
        respond result
    }

    def bbc(){
        render "Hello"
    }

    def index(){
        render "Hello World"
    }
}
