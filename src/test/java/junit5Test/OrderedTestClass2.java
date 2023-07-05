package junit5Test;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // instead of using static
public class OrderedTestClass2 {
    @BeforeAll
    public void beforeAll() {
        System.out.println("-- this is before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("-- this is before each");
    }

    @Order(3)
    @Test
    public void firstMethod() {
        System.out.println("first method test");
    }

    @Order(2)
    @Test
    @DisplayName("US12  - tc10 - second test method")
    public void secondMethod() {
        System.out.println("second method test");
    }

    @Order(1)
    @Test
    public void thirdMethod() {
        System.out.println("third method test");
    }

}
