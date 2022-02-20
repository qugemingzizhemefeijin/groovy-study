package cg.zz.chapter07

import groovy.xml.StreamingMarkupBuilder

// 使用MarkupBuilder 或 StreamingMarkupBuilder创建xml

langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

xmlDocument = new StreamingMarkupBuilder().bind {
    //
    mkp.xmlDeclaration()
    // 添加命名空间
    mkp.declareNamespace(computer: 'Computer')
    // 根标签
    languages {
        // 添加注释
        comment << "Created using StreamingMarkupBuilder"
        // 循环生成 <computer:language>标签
        langs.each {key, value ->
            computer.language(name: key) {
                author (value)
            }
        }
    }
}

println xmlDocument