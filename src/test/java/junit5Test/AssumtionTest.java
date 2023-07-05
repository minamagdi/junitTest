package junit5Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumtionTest {

    @ParameterizedTest(name = "Run:{index} - value:{arguments}") //to make it more readable
    @ValueSource(ints = {1, 5, 7})
    void intValues(int theParam) {

        assumeTrue(theParam > 4);
        System.out.println("the param = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"mina,magdy", "madonna,magdy", "nermen,roshdy"})
    public void csvSource_StringString(String param1, String param2) {

        assumeFalse(param2.equals("roshdy"),"the assumption failed because of param 2");
        System.out.println("param1 : " + param1 + "   param2 : " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"mina,29,true", "nermeen,29,false", "madonna,22,true"})
    public void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {

        assumingThat(param2 > 20,() -> System.out.println("the test is run"));
        System.out.println("param1 : " + param1 + " , param2 : " + param2 + " , param3 : " + param3);
    }
}
