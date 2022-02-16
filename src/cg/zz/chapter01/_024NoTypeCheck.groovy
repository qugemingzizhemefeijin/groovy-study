package cg.zz.chapter01

try {
    Integer val = 4
    val = 'hello'
} catch (Exception ex) {
    println ex.getClass().name
    println ex.message[0..56]
    println ex.message[57..-1]
} finally {
    println 'finally'
}

try {
    Integer val = 4
    val.blah()
} catch (Exception ex) {
    println ex.getClass().name
    println ex.message[0..62]
    println ex.message[63..-1]
} finally {
    println '错误方法'
}