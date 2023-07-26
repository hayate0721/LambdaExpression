import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("----------");
        list.forEach(s -> System.out.println(s));


        System.out.println("----------");
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(myString + " means " + first);
        });

        int result = calculator((a, b) -> a + b, 5, 2);

        var intList = Arrays.asList(
                new int[]{1, 2},
                new int[]{4, 5},
                new int[]{7, 8});

        intList.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Integer, Integer> p1 = (l, r) -> System.out.printf("[left: %d right: %d]%n", l, r);

        intList.forEach(a -> processPoint(a[0], a[1], p1));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        System.out.println("--------");
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". "
                + switch (i) {
            case 0 -> "one";
            case 1 -> "two";
            case 2 -> "three";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomSelectedValues(15,names,
                () -> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomList));
    }


    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomSelectedValues(int count, String[] values, Supplier<Integer> s) {

        String[] selectedValue = new String[count];
        for(int i = 0; i < count; i++){
            selectedValue[i] = values[s.get()];
        }

        return selectedValue;
    }


}
