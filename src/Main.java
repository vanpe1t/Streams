import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        System.out.println(Stream.iterate(0, i -> ++i)
                .limit(100)
                .filter(i -> i % 2 == 0)
                .count());

      BiConsumer<Integer, Integer> consumer = (integer, integer2)
                                                -> System.out.println("Минимальное значение: " + integer + " Максимальное значение: " + integer2);

      findMinMax(Stream.iterate(0, i -> (int) (Math.random() * 1000)), Integer::compare, consumer);

    }

    public static <T> void findMinMax (Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {

        T maxValue = null;
        T minValue = null;

        List<T> list = stream
                .limit(1000)
                . sorted(order)
                .collect(Collectors.toList());

        if (list.size() != 0) {
            maxValue = list.get(0);
            minValue = list.get(list.size() - 1);
        }
        minMaxConsumer.accept(maxValue, minValue);
    }

}