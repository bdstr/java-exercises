package training.creation;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExercise implements StreamCreator {

    @Override
    public IntStream positiveDigitsUsingOf() {
        return IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @Override
    public IntStream positiveDigitsUsingRange() {
        return IntStream.range(1, 10);
    }

    @Override
    public IntStream positiveDigitsUsingIterate() {
        return IntStream.iterate(1, i -> i < 10, i -> i + 1);
    }

    @Override
    public IntStream powersOfTwo() {
        return IntStream.iterate(2, i -> i <= 1024, i -> i * 2);
    }

    @Override
    public DoubleStream from0Till1WithTenSteps() {
        // Adding 0.1 and 0.2 outputs 0.30000000000000004 because of binary representation of that number
        // Solution below is workaround to satisfy tests
        return DoubleStream.iterate(0, i -> i < 1.0, i -> new BigDecimal(String.valueOf(i)).add(BigDecimal.valueOf(0.1)).doubleValue());
    }

    @Override
    public Stream<String> alphabet() {
        return IntStream.iterate('A', c -> c <= 'Z', c -> c + 1)
                .mapToObj(c -> String.valueOf((char) c));
    }
}
