package cg.zz.chapter06

// String方法扩展
class PriceExtension {

    public static double getPrice(String self) {
        def url = "http://ichart.finance.yahoo.com/table.csv?s=$self".toURL()

        def data = url.readLines()[1].split(",")
        Double.parseDouble(data[-1])
    }

}

class PriceStaticExtension {

    public static double getPrice(String selfType, String ticker) {
        def url = "http://ichart.finance.yahoo.com/table.csv?s=$ticker".toURL()

        def data = url.readLines()[1].split(",")
        Double.parseDouble(data[-1])
    }

}

def ticker = "ORCL"

println "Price for $ticker using instance method is ${String.getPrice(ticker)}"
println "Price for $ticker using static method is ${ticker.getPrice()}"
