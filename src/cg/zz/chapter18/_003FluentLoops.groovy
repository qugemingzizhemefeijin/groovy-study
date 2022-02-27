package cg.zz.chapter18

// 传统循环
for (int i=0;i<10;i++) {
    println(i)
}

// Groovy 方式
for (i in 0..9) {
    println i
}

0.upto(9) { println it}

10.times { println it}
