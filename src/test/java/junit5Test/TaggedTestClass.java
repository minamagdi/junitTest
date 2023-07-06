package junit5Test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)  // instead of using static
public class TaggedTestClass {
    @BeforeAll
    public void beforeAll() {
        System.out.println("-- this is before all");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("-- this is before each");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("-- this is after all");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("-- this is after each");
    }

    @Test
    @Tag("sanity")
    public void firstMethod() {
        System.out.println("first method test");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    @DisplayName("US12  - tc10 - second test method")
    public void secondMethod() {
        System.out.println("second method test");
    }

    @Test
    @Tag("sanity")
    void thirdMethod() {
        System.out.println("third method test");
    }
    @Tag("acceptance")
    @Tag("sanity")
    @ParameterizedTest(name = "Run:{index} - value:{arguments}") //to make it more readable
    @ValueSource(ints = {1, 5, 7})
    void intValues(int theParam) {
        System.out.println("the param = " + theParam);
    }

}
