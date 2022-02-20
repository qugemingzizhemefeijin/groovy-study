package cg.zz.chapter07

languages = new XmlSlurper().parse("languages.xml")
println "Languages and authors"

languages.language.each {
    println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
    languages.language.findAll { it.author[0].text() == authorName }.collect { it.@name }.join(", ")
}

println "Languages by Wirth: " + languagesByAuthor('Wirth')