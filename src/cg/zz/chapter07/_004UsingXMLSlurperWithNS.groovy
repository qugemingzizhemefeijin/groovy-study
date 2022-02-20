package cg.zz.chapter07

// 对于较大的XML文档，最好使用XMLSlurper，它执行惰性求职，所以内存使用比较友好，而且开销较低。

languages = new XmlSlurper().parse(
        'computerAndNaturalLanguages.xml'
).declareNamespace(human: 'Natural')

print "Languages: "
println languages.language.collect { it.@name }.join(", ")

print "Natural languages: "
println languages.'human:language'.collect { it.@name }.join(", ")