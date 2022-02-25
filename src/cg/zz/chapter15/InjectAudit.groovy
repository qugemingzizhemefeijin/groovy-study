package cg.zz.chapter15

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

// 这里 CompilePhase.SEMANTIC_ANALYSIS 告诉编译器在语义解析阶段的最后应用该变换。
// 最后创建清单文件META-INF/services/org.codehaus.groovy.transfrom.ASTTransformation
@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class InjectAudit implements ASTTransformation {
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
        def checkingAccountClassNode =
                astNodes[0].classes.find { it.name == 'CheckingAccount' }
        injectAuditMethod(checkingAccountClassNode)
    }

    // 这里获取除audit()之外的所有方法。在每个方法的开头加入一个对audit()方法的调用。
    static void injectAuditMethod(checkingAccountClassNode) {
        def nonAuditMethods =
                checkingAccountClassNode?.methods.findAll { it.name != 'audit' }
        println nonAuditMethods
        nonAuditMethods?.each { injectMethodWithAudit(it) }
    }

    static void injectMethodWithAudit(methodNode) {
        def callToAudit = new ExpressionStatement(
                new MethodCallExpression(
                        new VariableExpression('this'),
                        'audit',
                        new ArgumentListExpression(methodNode.parameters)
                )
        )

        methodNode.code.statements.add(0, callToAudit)
    }
}
