package myapp

import grails.transaction.Transactional


@Transactional
class TestService {

    def testMethod(String keywords) {
        def count = Programme.countHits(keywords)
        List<Programme> programmes = Programme.searchTop(keywords, count)

        return programmes
    }


}
