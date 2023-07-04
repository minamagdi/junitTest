package junit5Test;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider { // in case data in different class
    static Stream<Arguments> sourceStream_StringDouble_outClass() {
        return Stream.of(arguments("tomato",23.21),arguments("cabbage",12.3));
    }
}
