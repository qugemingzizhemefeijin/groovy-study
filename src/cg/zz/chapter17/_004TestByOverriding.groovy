package cg.zz.chapter17

class _004TestByOverriding extends GroovyTestCase {

    void testMyMethod() {
        def testObj = new CodeWithHeavierDependenciesExt()

        testObj.myMethod()

        assertEquals 35, testObj.result
    }

}

class CodeWithHeavierDependenciesExt extends CodeWithHeavierDependencies {
    def result

    int someAction() { 25 }

    def println(text) {
        result = text
    }
}
