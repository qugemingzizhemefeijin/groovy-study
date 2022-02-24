package cg.zz.chapter10

// 如果POGO没有实现GroovyInterceptable，那么GroovyUI先查找它的MetaClass中的方法，之后，如果没有找到，则查找POGO自身上的方法；
// 如果该POGO没有这样的方法，Groovy会以方法名查找属性和字段。如果属性或字段是Closure类型的，Groovy会调用它，替代方法调用。
// 如果Groovy没有找到这样的属性和字段，它会做最后两次尝试。
// 如果POGO有一个名为methodMissing()方法，则调用该方法。否则调用POGO的invokeMethod()方法。
// 如果POGO实现了这个方法，它会被调用。否则会抛出一个MissingMethodException异常，说明调用失败。

class AnInterceptable implements GroovyInterceptable {
    def existingMethod() {}
    def invokeMethod(String name, args) { 'intercepted' }
}

class AGroovyObject {
    def existingMethod() { 'existingMethod' }
    def existingMethod2() { 'existingMethod2' }
    def closureProp = { 'closure called' }
}

class ClassWithInvokeAndMissingMethod {
    def existingMethod() { 'existingMethod' }
    def invokeMethod(String name, args) { 'invoke called' }
    def methodMissing(String name, args) { 'missing called' }
}

class ClassWithInvokeOnly {
    def existingMethod() { 'existingMethod' }
    def invokeMethod(String name, args) { 'invoke called' }
}

class TestMethodInvocation extends GroovyTestCase {

    void testInterceptedMethodCallonPOJO() {
        def val = new Integer(3)
        Integer.metaClass.toString = {-> 'intercepted' }

        assertEquals "intercepted", val.toString()
    }

    void testInterceptableCalled() {
        def obj = new AnInterceptable()
        assertEquals 'intercepted', obj.existingMethod()
        assertEquals 'intercepted', obj.nonExistingMethod()
    }

    void testInterceptedExistingMethodCalled() {
        AGroovyObject.metaClass.existingMethod2 = {-> 'intercepted' }
        def obj = new AGroovyObject()
        assertEquals 'intercepted', obj.existingMethod2()
    }

    void testUnInterceptedExistingMethodCalled() {
        def obj = new AGroovyObject()
        assertEquals 'existingMethod', obj.existingMethod()
    }

    void testPropertyThatIsClosureCalled() {
        def obj = new AGroovyObject()
        assertEquals 'closure called', obj.closureProp()
    }

    void testMethodMissingCalledOnlyForNonExistent() {
        def obj = new ClassWithInvokeAndMissingMethod()
        assertEquals 'existingMethod', obj.existingMethod()
        assertEquals 'missing called', obj.nonExistingMethod()
    }

    void testInvokeMethodCalledForOnlyNonExistent() {
        def obj = new ClassWithInvokeOnly()
        assertEquals 'existingMethod', obj.existingMethod()
        assertEquals 'invoke called', obj.nonExistingMethod()
    }

    void testMethodFailsOnNonExistent() {
        def obj = new TestMethodInvocation()
        shouldFail (MissingMethodException) { obj.nonExistingMethod() }
    }

}

