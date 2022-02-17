package cg.zz.chapter02

// java在使用父类的时候，只会调用重载的方法，如下

/*public class Employee {
    public void raise(Number amount) {
        System.out.println("Employee got raise");
    }
}

public class Executive extends Employee {
    public void raise(Number amount) {
        System.out.println("Executive got raise");
    }

    public void raise(java.math.BigDecimal amount) {
        System.out.println("Executive got outlandish raise");
    }
}

public class GiveRaiseJava {
    public static void giveRaise(Employee employee) {
        employee.raise(new BigDecimal(10000.00));
    }

    public static void main(String[] args) {
        giveRaise(new Employee());
        giveRaise(new Executive());
    }
}*/

// 输出结果为，因为找到的是Number。
// Employee got raise
// Executive got raise

// groovy 可以找到我们真正想调用的方法

class Employee {
    def raise(Number amount) {
        System.out.println("Employee got raise");
    }
}

class Executive extends Employee {
    def raise(Number amount) {
        System.out.println("Executive got raise");
    }
    def raise(BigDecimal amount) {
        System.out.println("Executive got outlandish raise");
    }
}

void giveRaise(Employee employee) {
    employee.raise(new BigDecimal(10000.00))
}

giveRaise new Employee()
giveRaise new Executive()

// 输出结果
// Employee got raise
// Executive got outlandish raise