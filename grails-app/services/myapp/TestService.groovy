package myapp

import grails.transaction.Transactional


@Transactional
class TestService {

    def testMethod() {
        //def result = Programme.findAllById("5906252136ac939ea93b40d2")

       def result = Programme.findByPid("p003k9ct")
        return result
    }


}
