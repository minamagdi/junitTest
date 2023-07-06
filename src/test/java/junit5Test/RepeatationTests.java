package junit5Test;

import org.junit.jupiter.api.*;

public class RepeatationTests {

    @RepeatedTest(5)
    public void firstRepeatedMethod() {
        System.out.println("we are repeating this test");
    }

    @RepeatedTest(value = 3,name = "Running Test : {currentRepetition}." +
            "total is :{totalRepetitions}")
    @DisplayName("repetition")
    public void secondRepeatedMethod() {
        System.out.println("we are repeating new test");
    }

    @RepeatedTest(4)
    public void thirdRepeatedMethod(RepetitionInfo repetitionInfo) {
        System.out.println("we are repeating test");

        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition()==3,()-> System.out.println("this no 3"));

    }
}
