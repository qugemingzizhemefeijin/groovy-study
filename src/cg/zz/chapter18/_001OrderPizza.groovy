package cg.zz.chapter18

// 使用with，就显得比Java没那么乱
PizzaShop joesPizza = new PizzaShop()
joesPizza.with {
    setSize(Size.LARGE)
    setCrust(Crust.THIN)
    setTopping("Olives", "Onions", "Bell Pepper")
    setAddress("101 Main St., ...")
    int time = setCard(CardType.VISA, "1234-1234-1234-1234")

    printf("Pizza will arrive in %d minutes\n", time)
}
