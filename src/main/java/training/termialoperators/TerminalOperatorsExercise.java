package training.termialoperators;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperatorsExercise implements StreamTerminalOperators {

    @Override
    public void addToSet(Stream<String> stream, Set<String> set) {
        stream.forEach(set::add);
    }

    @Override
    public void addToListInReverseOrder(Stream<String> stream, List<String> list) {
        stream.sorted(Comparator.reverseOrder()).forEach(list::add);
    }

    @Override
    public String[] collectToArray(Stream<String> stream) {
        return stream.toArray(String[]::new);
    }

    @Override
    public Set<String> collectToSet(Stream<String> stream) {
        return stream.collect(Collectors.toSet());
    }

    @Override
    public List<String> collectToList(Stream<String> stream) {
        return stream.collect(Collectors.toList());
    }

    @Override
    public String mergeIntoString(Stream<String> stream) {
        return stream.collect(Collectors.joining("-", "[", "]"));
    }

    @Override
    public int countCharacters(Stream<String> stream) {
        return stream.collect(Collectors.joining()).length();
    }

    @Override
    public int longestWordLength(Stream<String> stream) {
        return stream.mapToInt(String::length)
                .max()
                .orElse(0);
    }

    @Override
    public String longestWord(Stream<String> stream) {
        return stream.max(Comparator.comparingInt(String::length)).orElse("");
    }

    @Override
    public Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream) {
        return stream.collect(Collectors.groupingBy(String::length, Collectors.toList()));
    }
}
