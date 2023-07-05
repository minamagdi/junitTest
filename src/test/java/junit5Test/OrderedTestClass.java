package junit5Test;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.MethodName.class) //display depend on method name
@TestMethodOrder(MethodOrderer.DisplayName.class)  //display depend on display name annotation
@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // instead of using static
public class OrderedTestClass {
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

    @Test
    @DisplayName("A display name")
    public void thirdMethod() {
        System.out.println("third method test");
    }
}
