package cg.zz.chapter09

class UseAGroovyClass2 {

    public static void main(String[] args) {
        AGroovyClass instance = new AGroovyClass();
        //Java code
        System.out.println("Received: " + instance.passToClosure(2, new Object() {
            public String call(int value) {
                return "You called from Groovy with value " + value;
            }
        }));
    }

}
