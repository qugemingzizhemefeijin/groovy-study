package cg.zz.chapter05

langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

langs.each {
    entry ->
        println "Language $entry.key was authored by $entry.value"
}

println '======================================='
langs.each {language, author ->
    println "Language $language was authored by $author"
}

println '======================================='

// collect方法使用
println langs.collect {language, author ->
    language.replaceAll("[+]", "P")
}

println '======================================='
// find和findAll方法
println "Looking for the first language name greater than 3 characters"
entry = langs.find {language, author ->
    language.size() > 3
}
println "Found $entry.key written by $entry.value"

println '======================================='
println "Looking for the first language name greater than 3 characters"
selected = langs.findAll {language, author ->
    language.size() > 3
}
selected.each {key, value ->
    println "Found $key written by $value"
}

println '======================================='
// 如果只是想确定集合中是否与符合条件的元素，可以直接使用any
print "Does any language name have a nonalphabetic character? "
println langs.any {language, author ->
    language =~ "[^A-Za-z]"
}

// any会查找至少一个满足给定条件的元素，而every是检查是否所有的元素满足给定条件
print "Do all language names have a nonalphabetic character? "
println langs.every {language, author ->
    language =~ "[^A-Za-z]"
}

println '======================================='
friends = [ briang : 'Brian Goetz', brians : 'Brian Sletten',
            davidb : 'David Bock', davidg : 'David Geary',
            scottd : 'Scott Davis', scottl : 'Scott Leberknight',
            stuarth : 'Stuart Halloway']
// 对firstName进行分组
groupByFirstName = friends.groupBy { it.value.split(" ")[0] }

groupByFirstName.each {firstName, buddies ->
    println "$firstName : ${buddies.collect {key, fullName -> fullName}.join(", ")}"
}