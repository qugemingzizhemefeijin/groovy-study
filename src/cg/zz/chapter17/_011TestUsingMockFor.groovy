package cg.zz.chapter17

import groovy.mock.interceptor.MockFor

class _011TestUsingMockFor extends GroovyTestCase {

    void testMethodB() {
        def testObj = new ClassWithDependency()

        // 与存根不同，模拟会支出，纵然代码产生了指定的结果，但是其表现与预期不符。
        // 也就是说，这段代码没有调用使用demand在测试预期中设置的close()方法
        def fileMock = new MockFor(FileWriter)
        def text

        fileMock.demand.write { text = it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.methodB(1)
        }

        assertEquals "The value is 1.", text
    }

}
