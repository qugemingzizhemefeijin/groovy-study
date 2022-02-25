package cg.zz.chapter15

// 应用编译时元编程

// 每次超过10000存款、取款和转账都需要经过审计。。
// 通常做法就是修改方法，每个方法上加个判断，或者是通过方法拦截来实现。
// 这里使用AST技术

// 编译步骤
// groovyc -d classes cg/zz/chapter15/InjectAudit.groovy
// jar -cf injectAudit.jar -C classes cg -C manifest .
// 直接调用的话是没有拦截的 groovy cg/zz/chapter15/_001UsingCheckingAccount.groovy
// 被拦截调用 groovy -classpath injectAudit.jar cg/zz/chapter15/_001UsingCheckingAccount.groovy

// 没试验成功？？
class CheckingAccount {
    def audit(amount) { if (amount > 10000) print "auditing..." }

    def deposit(amount) { println "depositing ${amount}..." }

    def withdraw(amount) { println "withdrawing ${amount}..." }
}

def account = new CheckingAccount()
account.deposit(1000)
account.deposit(12000)
account.withdraw(11000)
