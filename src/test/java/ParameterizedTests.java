import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {
    @ParameterizedTest(name = "Run:{index} - value:{arguments}") //to make it more readable
    @ValueSource(ints = {1, 5, 7})
    void intValues(int theParam) {
        System.out.println("the param = " + theParam);
    }

    @ParameterizedTest
    @ValueSource(strings = {"firstString", "secondString"})
    //@EmptySource                                               //don't work with int bool float
    //@NullSource                                                //null
    @NullAndEmptySource                                        // = @EmptySource +  @NullSource
    public void stringValues(String theParam) {
        System.out.println("the param : " + theParam);
    }


    @ParameterizedTest
    @CsvSource(value = {"mina,magdy", "madonna,magdy", "nermen,roshdy"})
    public void csvSource_StringString(String param1, String param2) {
        System.out.println("param1 : " + param1 + "   param2 : " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"mina,29,true", "nermeen,29,false", "madonna,22,true"})
    public void csvSource_StringIntBoolean(String param1, int param2, boolean param3) {
        System.out.println("param1 : "+param1 + " , param2 : "+param2 +" , param3 : "+param3);
    }
}
