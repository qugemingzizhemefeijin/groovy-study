package cg.zz.chapter07

// XMLParser的使用，这个不足之处就是没有保留XML InfoSet，忽略了文档中的XML注释和处理指令。

languages = new XmlParser().parse("languages.xml")

println "Languages and authors"

languages.each {
    println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = {authorName ->
    languages.findAll { it.author[0].text() == authorName }.collect { it.@name }.join(", ")
}

println "Languages by Wirth: " + languagesByAuthor('Wirth')
