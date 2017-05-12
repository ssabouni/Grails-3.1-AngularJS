package myapp

class TestController {
	//static responseFormats = ['json', 'xml']
    def testService

    def search(String keywords){
        if (keywords != null){
            def results = testService.searchMethod(keywords)
            respond results, model:[resultsCount: results.size()]
        }
    }

    def signed(){
        def results = testService.signedMethod()
        respond results, model:[resultsCount: results.size()]
    }

    def tags(){
        def tags = testService.tagsMethod()
        respond tags, model:[tags:tags]
    }

    def categories(){
        def categories = testService.categoriesMethod()
        respond categories, model:[categories:categories]
    }

    def masterbrand(){
        def masterbrand = testService.masterbrandMethod()
        respond masterbrand, model:[masterbrand:masterbrand]
    }

    def advanced(boolean dubbed, boolean signed, String media, String masterbrand, String keywords,
                 boolean clip){
        int intClip;
        if (clip){
            intClip = 1;
        }
        else{
            intClip = 0;
        }

        //def startTime = params.getDate("startTime")
        //def endTime = params.getDate("endTime")
        def results = testService.advancedSearch(dubbed, signed, media, masterbrand, keywords, intClip)
        respond results, model:[advancedResults: results]
    }
}
