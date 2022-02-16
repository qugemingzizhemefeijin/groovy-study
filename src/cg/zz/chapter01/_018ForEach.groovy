package cg.zz.chapter01

String[] greeting = ['Hello', 'World', 'Groovy']
// java风格的循环
for(String greet : greeting) {
    print "${greet} "
}
println()

// groovy
for(greet in greeting) {
    print "${greet} "
}
println()