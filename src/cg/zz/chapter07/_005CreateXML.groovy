package cg.zz.chapter07

// 使用纯粹的字符串生成xml
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

content = ''
langs.each { language, author ->
    fragment = """
    <language name="${language}">
      <author>${author}</author>
    </language>
  """

    content += fragment
}
xml = "<languages>${content}</languages>"
println xml