package cg.zz.chapter01

// 方法的变长参数
def receiveVarArgs(int a, int... b) {
    println "You passed $a and $b"
}

def receiveArray(int a, int[] b) {
    println "You passed $a and $b"
}

receiveVarArgs(1, 2, 3, 4, 5)
receiveArray(1, 2, 3, 4, 5)

int[] values = [2, 3, 4, 5]
receiveVarArgs(1, values)
receiveVarArgs(1, [2, 3, 4, 5] as int[])

receiveArray(1, values)
receiveArray(1, [2, 3, 4, 5] as int[])

// Groovy会将包括在方括号中的值看做是ArrayList，所以下面会报错 MissingMethodException
try {
    receiveVarArgs(1, [2, 3, 4, 5])
} catch(ex) {
    println ex.getClass()
}

try {
    receiveArray(1, [2, 3, 4, 5])
} catch(ex) {
    println ex.getClass()
}
