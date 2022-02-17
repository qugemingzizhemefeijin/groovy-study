package cg.zz.chapter02
// 如果使用@CompileStatic可以让groovy执行静态编译，生成与javac编译相似的字节码，提高性能

//@CompileStatic
def shout1(String str) {
    println str.toUpperCase()
}
println 'works'

// 加 @CompileStatic 注解
//         0: aload_0
//         1: checkcast     #2                  // class cg/zz/chapter02/_008StaticCompile
//         4: aload_1
//         5: invokevirtual #55                 // Method java/lang/String.toUpperCase:()Ljava/lang/String;
//         8: invokevirtual #59                 // Method println:(Ljava/lang/Object;)V
//        11: aconst_null
//        12: areturn

// 不加 @CompileStatic 注解
//         0: nop
//         1: invokestatic  #16                 // Method $getCallSiteArray:()[Lorg/codehaus/groovy/runtime/callsite/CallSite;
//         4: astore_2
//         5: aload_2
//         6: ldc           #50                 // int 2
//         8: aaload
//         9: aload_0
//        10: aload_2
//        11: ldc           #51                 // int 3
//        13: aaload
//        14: aload_1
//        15: invokeinterface #54,  2           // InterfaceMethod org/codehaus/groovy/runtime/callsite/CallSite.call:(Ljava/lang/Object;)Ljava/lang/Object;
//        20: invokeinterface #47,  3           // InterfaceMethod org/codehaus/groovy/runtime/callsite/CallSite.callCurrent:(Lgroovy/lang/GroovyObject;Ljava/lang/Object;)Ljava/lang/Object;
//        25: areturn