package cg.zz.chapter16

import groovy.xml.StreamingMarkupBuilder

langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

xmlDocument = new StreamingMarkupBuilder().bind {
    mkp.xmlDeclaration()
    // 申明命名空间
    mkp.declareNamespace(computer: 'Computer')
    languages {
        comment << 'Created using StreamingMarkupBuilder'
        langs.each { key, value ->
            computer.language(name: key) {
                author(value)
            }
        }
    }
}

println xmlDocument
