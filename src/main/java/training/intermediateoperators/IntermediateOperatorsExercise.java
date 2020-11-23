package training.intermediateoperators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperatorsExercise implements StreamIntermediateOperators {

    @Override
    public Stream<String> wordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(w -> w.length() > 5);
    }

    @Override
    public Stream<String> firstThreeWordsLongerThanFiveCharacters(List<String> words) {
        return words.stream().filter(w -> w.length() > 5).limit(3);
    }

    @Override
    public Stream<String> firstThreeDistinctWordsLongerThanFiveCharactersInReverseAlphabeticalOrder(List<String> words) {
        return words.stream().filter(w -> w.length() > 5)
                .distinct()
                .limit(3)
                .sorted(Comparator.reverseOrder());
    }

    @Override
    public Stream<Integer> lengthOfWords(List<String> words) {
        return words.stream().map(String::length);
    }

    @Override
    public Stream<Integer> staircase() {
        List<IntStream> intStreamList = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            intStreamList.add(IntStream.range(0, i));
        }

        return intStreamList
                .stream()
                .flatMap(IntStream::boxed);
    }
}
