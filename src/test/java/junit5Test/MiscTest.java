package junit5Test;

import org.junit.jupiter.api.*;

public class MiscTest {

    @Test
    @Timeout(5)
    void timeOut() throws InterruptedException {
        System.out.println("test");
        Thread.sleep(6000);
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class NestedClass{
        @BeforeAll
        void beforeAll(){
            System.out.println("before all");
        }


        @Test
        void nestedMethod(){
            System.out.println("nested");
        }
    }
}
