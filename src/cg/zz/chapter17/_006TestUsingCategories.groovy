package cg.zz.chapter17

// 让分类拦截对方法的调动，并在适当的情况下替换这个两个方法。
class _006TestUsingCategories extends GroovyTestCase {

    void testMyMethod() {
        def testObj = new CodeWithHeavierDependencies()

        use(MockHelper) {
            testObj.myMethod()

            assertEquals 35, MockHelper.result
        }
    }

}

class MockHelper {

    def static result

    def static println(self, text) {
        result = text
    }

    def static someAction(CodeWithHeavierDependencies self) { 25 }

}
