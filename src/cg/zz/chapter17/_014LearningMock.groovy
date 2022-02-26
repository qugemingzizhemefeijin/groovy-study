package cg.zz.chapter17

import groovy.mock.interceptor.MockFor

// 模拟方法调用的次数
class _014LearningMock extends GroovyTestCase {

    void testSomeWriter() {
        def testObj = new Sample()
        def params = ['one', 'two', 3]
        def index = 0

        def fileMock = new MockFor(FileWriter)
        // 代表方法被调用了3次，如果想表达最多3次，使用0..3
        fileMock.demand.write(3..3) { assert it == params[index++] } // 这里可以判断传入的参数是否正确
        fileMock.demand.flush {}
        fileMock.demand.getEncoding { return "whatever" } // return 是可选的
        fileMock.demand.write { assertEquals 'whatever', it.toString() }
        fileMock.demand.close {}

        fileMock.use {
            testObj.someWriter()
        }
    }

}


class Sample {

    def someWriter() {
        def file = new FileWriter('output.txt')
        file.write('one')
        file.write('two')
        file.write(3)
        file.flush()
        file.write(file.getEncoding())
        file.close()
    }

}