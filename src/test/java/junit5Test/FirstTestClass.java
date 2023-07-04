package junit5Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTestClass {
    @Test
    public void firstMethod(){
        System.out.println("first method test");
    }
    @Test
    @DisplayName("US12  - tc10 - second test method")
    public void secondMethod(){
        System.out.println("second method test");
    }
}
