package junit5Test;

import org.junit.jupiter.api.*;
//interminal or execute maven goal
//mvn test -Dtest=FirstTestClass
//mvn test -Dtest=FirstTestClass#secondMethod
//mvn test -Dtest=FirstTestClass,RepeatedTest
//goto edit configration delete all config and add new select tag and then write any tag u want to run

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // instead of using static
public class FirstTestClass {
    @BeforeAll
    public void beforeAll() {
        System.out.println("-- this is before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("-- this is before each");
    }

    @Test
    public void firstMethod() {
        System.out.println("first method test");
    }

    @Test
    @DisplayName("US12  - tc10 - second test method")
    public void secondMethod() {
        System.out.println("second method test");
    }
}
