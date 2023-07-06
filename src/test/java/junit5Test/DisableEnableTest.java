package junit5Test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DisableEnableTest {

    @Test
    @Disabled        //first way but you can run it separately
    public void firstMethod() {
        System.out.println("first method test");
    }

    @Test
    @Disabled(value = "disabled for demo @Disabled") //second way but you can run it separately
    public void secondMethod() {
        System.out.println("second method test");
    }
    @Test
    @DisabledOnOs(value = OS.WINDOWS,disabledReason = "disabled for demo @disabled")//third way but you can run it
    // separately
    public void thirdMethod() {
        System.out.println("third method test");
    }

    @Test
    @EnabledOnOs(value = OS.WINDOWS,disabledReason = "disabled for demo @disabled")
    public void fourthMethod() {
        System.out.println("four method test");
    }

    @Test
    /*
    * steps :
    *      1- select edit config
    *      2--ea -Denv=staging
    * */
    @DisabledIfSystemProperty(named = "env",matches = "staging",disabledReason = "error")
    public void fifthMethod() {
        System.out.println("five method test");
    }
    @Test
    @DisabledIf(value = "provider")
    public void sixthMethod() {
        System.out.println("four method test");
    }
    boolean provider() {
        return LocalDateTime.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
    }
}
