package cg.zz.chapter04

// 多行字符串

// 3个单引号或者3个双引号（这个里面可以写表达式）

memo = '''Several of you raised concerns about long meetings.
To discuss this, we will be holding a 3 hour meeting starting
at 9AM tomorrow. All getting this memo are required to attend.
If you can't make it, please have a meeting with your manager to explain.
'''

println memo

price = 251.12

message = """We're very pleased to announce
that our stock price hit a high of \$${price} per share
on December 24th. Great news in time for...
"""

println message

// map读取
langs = ['C++' : 'Stroustrup', Java : 'Gosling', Lisp : 'McCarthy']
println langs

message = """We're very pleased to announce
that our stock price hit a high of ${langs.get("C++")} per share
on December 24th. Great news in time for...
"""

println message
