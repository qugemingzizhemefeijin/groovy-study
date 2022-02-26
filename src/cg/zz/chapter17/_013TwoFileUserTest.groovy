package cg.zz.chapter17

import groovy.mock.interceptor.MockFor

// 如果方法会创建多个实例，又怎么模拟呢？
class _013TwoFileUserTest extends GroovyTestCase {

    void testUseFiles() {
        def testObj = new TwoFileUser()
        def testData = 'Multi Files'
        def fileMock = new MockFor(FileWriter)
        fileMock.demand.write() { assertEquals testData, it }
        fileMock.demand.write() { assertEquals testData.size(), it }
        fileMock.demand.close(2..2) {}
        fileMock.use {
            testObj.useFiles(testData)
        }
    }

    void tearDown() {
        new File('output1.txt').delete()
        new File('output2.txt').delete()
    }

}

class TwoFileUser {
    def useFiles(str) {
        def file1 = new FileWriter("output1.txt")
        def file2 = new FileWriter("output2.txt")

        file1.write str
        file2.write str.size()
        file1.close()
        file2.close()
    }
}
