package cg.zz.chapter17

class _005TestJavaByOverride extends GroovyTestCase {

    void testMyMethod() {
        def testObj = new ExtendedJavaCode()

        // 这里通过交换System.out，可以支持System.out.println输出到result中，并进行测试判断。
        def originalPrintStream = System.out
        def printMock = new PrintMock()
        System.out = printMock

        try {
            testObj.myMethod()
        } finally {
            System.out = originalPrintStream
        }

        assertEquals 35, printMock.result
    }

}

class ExtendedJavaCode extends JavaCodeWithHeavierDependencies {
    int someAction() { 25 }
}

class PrintMock extends PrintStream {

    PrintMock() { super(System.out) }

    def result

    void println(int text) {
        result = text
    }

}