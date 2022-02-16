package cg.zz.chapter01

// 多种循环的方式
for (i in 0..2) {
    print "$i "
}
println()

// 2
0.upto(2) {
    print "$it "
}
println()

// 3
3.times() {
    print "$it "
}
println()

// 4
0.step(10, 2) {
    print "$it "
}
println()

// 4
3.times { print 'ho ' }
println 'Merry Groovy!'
