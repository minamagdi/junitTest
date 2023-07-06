package junit5Test;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
        System.out.println("param1 : " + param1 + " , param2 : " + param2 + " , param3 : " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"mina magdy,'ali,kamel'", "moheb samy,'ahmed,galal'"})
     void csvSource_StringWithComa(String param1, String param2) {
        System.out.println("param1 : " + param1 + " ,param2 : " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"mina?magdy", "ali?maher"}, delimiter = '?')
     void csvSource_StringWithDiffDelimiter(String param1, String param2) {
        System.out.println("param1 : " + param1 + ", param2: " + param2);
    }

    @ParameterizedTest
    //@CsvFileSource(files = "src/test/resources/params/shoppingList.csv",numLinesToSkip = 1)//to skip first line of file in case of one file
//    @CsvFileSource(files ={"src/test/resources/params/shoppingList.csv","src/test/resources/params/shoppingList2.csv"},numLinesToSkip = 1)

    @CsvFileSource(files = "src/test/resources/params/shoppingList3.csv", numLinesToSkip = 1, delimiterString = "***")
    public void csvSource_StringDoubleIntStringString(String name, Double price,
                                                      int quantity, String unit,
                                                      String provider) {
        System.out.println("name : " + name + " , price : " + price + " , quantity : " + quantity + " , unit : " +
                unit + " provider: " + provider);

    }

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1) {
        System.out.println("param1 : " + param1);
    }

    List<String> sourceString() {
        return Arrays.asList("tomato", "carrot", "cabbage");
    }
    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringAsStream(String param1) {
        System.out.println("param1 : " + param1);
    }
    Stream<String> sourceStringAsStream() {
        return Stream.of("beetRoot","apple","pear");
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    public void methodSource_StringDoubleList(String param1 , double param2) {
        System.out.println("param1 : "+param1 + " ,param2 : "+param2);
    }

    List<Arguments> sourceList_StringDouble() {
        return Arrays.asList(arguments("tomato",2.0),
                arguments("carrot",3.5),
                arguments("cabbage",9.6));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStream_StringDouble")
    public void methodSource_StringDoubleStream(String param1 , double param2) {
        System.out.println("param1 : "+param1 + " ,param2 : "+param2);
    }
    Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(arguments("tomato",23.21),arguments("cabbage",12.3));
    }

    /*
    * only difference here is :
    * value = "junit5Test.ParamProvider#sourceStream_StringDouble_outClass"
    * */
    @ParameterizedTest
    @MethodSource(value = "junit5Test.ParamProvider#sourceStream_StringDouble_outClass")
    public void methodSource_StringDoubleStream_outClass(String param1 , double param2) {
        System.out.println("param1 : "+param1 + " ,param2 : "+param2);
    }
}
