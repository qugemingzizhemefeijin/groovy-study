package cg.zz.chapter18

// 这个代码比前面的更轻巧
PizzaShop joesPizza = new PizzaShop()
joesPizza.with {
    setSize Size.LARGE
    setCrust Crust.THIN
    setTopping "Olives", "Onions", "Bell Pepper"
    setAddress "101 Main St, ..."
    time = setCard CardType.VISA, "1234-1234-1234-1234"

    printf "Pizza will arrive in %d minutes\n", time
}