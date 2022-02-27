package cg.zz.chapter18

// 闭包与DSL

// 这里是如何得到time的值的？
// 因为getPizza()中最后一条语句是调用闭包，所以闭包返回什么，这个方法就返回什么。
// 闭包以后一条语句是setCard()，所以该方法的结果会被返回给调用者。
time = getPizza() {
    setSize Size.LARGE
    setCrust Crust.THIN
    setTopping "Olives", "Onions", "Bell Pepper"
    setAddress "101 Main St, ..."
    setCard CardType.VISA, "1234-1234-1234-1234"
}

printf "Pizza will arrive in %d minutes\n", time

def getPizza(closure) {
    PizzaShop pizzaShop = new PizzaShop()
    closure.delegate = pizzaShop
    closure()
}