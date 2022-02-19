package cg.zz.chapter04

// 要从字符串创建一个模式，使用~操作符；
// 要定义一个RegEx，使用正斜杠，像/[G|g]roovy/，但是必须使用在=~或==~右侧。不可以单独定义，否则就是字符串了。
// 要确定是否存在匹配，使用=~。
// 对于精确匹配，使用==~。

// 这里会创建一个 java.util.regex.Pattern 对象
obj = ~"Hello"
println obj.getClass().name

// =~执行RegEx部分匹配，而==~执行RegEx精确匹配。
pattern = ~"(G|g)roovy"
text = 'Groovy is Hip'
if (text =~ pattern) {
    println "match"
} else {
    println "no match"
}

if (text ==~ pattern) {
    println "match"
} else {
    println "no match"
}

// =~操作符会返回一个Matcher对象。
matcher = 'Groovy is groovy' =~ /(G|g)roovy/
println "Size of match is ${matcher.size()}"
println "with elements ${matcher[0]} and ${matcher[1]}."

// 可以使用replaceFirst()方法或replaceAll()方法替换匹配的文本
str = 'Groovy is groovy, really groovy'
println str
result = (str =~ /groovy/).replaceAll('hip')
println result
