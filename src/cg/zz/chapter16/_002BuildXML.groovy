package cg.zz.chapter16

import groovy.xml.MarkupBuilder

langs = ['C++' : 'Stroustrup', 'Java': 'Gosling', 'Lisp' : 'McCarthy']

writer = new StringWriter()
bldr = new MarkupBuilder(writer)
bldr.languages {
    langs.each {key, value ->
        language(name: key) {
            author(value)
        }
    }
}

println writer
