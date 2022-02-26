package cg.zz.chapter17

class _002CarTest extends GroovyTestCase {

    def car

    void setUp() {
        car = new Car()
    }

    void testInitialize() {
        assertEquals 0, car.miles
    }

    void testDrive() {
        car.drive(10)
        assertEquals 10, car.miles
    }

    // 负面测试
    void testDriveNegativeInput() {
        car.drive(-10)
        assertEquals 0, car.miles
    }

}
