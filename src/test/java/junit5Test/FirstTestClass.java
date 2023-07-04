package junit5Test;

import org.junit.jupiter.api.*;

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
