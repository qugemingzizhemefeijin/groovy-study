package cg.zz.chapter09

println "In Script2"

shell = new GroovyShell()
shell.evaluate(new File("_007Script1.groovy"))

// 或者更简单点
evaluate(new File("_007Script1.groovy"))