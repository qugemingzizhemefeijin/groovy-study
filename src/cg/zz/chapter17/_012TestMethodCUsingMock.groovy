package cg.zz.chapter17

import groovy.mock.interceptor.MockFor

class _012TestMethodCUsingMock extends GroovyTestCase {

    void testMethodC() {
        def testObj = new ClassWithDependency()

        def fileMock = new MockFor(FileWriter)
        def text

        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {}
        fileMock.use {
            testObj.methodC(1)
        }

        assertEquals "The value is 1.", text
    }

}
