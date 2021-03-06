package cg.zz.chapter07

import groovy.xml.DOMBuilder
import groovy.xml.dom.DOMCategory

// DOMCategory的使用

document = DOMBuilder.parse(new FileReader("languages.xml"))

rootElement = document.documentElement

// 属性名称之前放一个@可以获取该属性的值
use(DOMCategory) {
    println "Languages and authors"
    languages = rootElement.language

    languages.each { language ->
        println "${language.'@name'} authored by ${language.author[0].text()}"
    }

    def languagesByAuthor = {authorName ->
        languages.findAll {it.author[0].text() == authorName}.collect { it.'@name' }.join(', ')
    }

    println "Languages by Wirth:" + languagesByAuthor('Wirth')
}
