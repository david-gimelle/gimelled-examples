package com.gimelle.sandbox.javaeight;

import com.gimelle.sandbox.optional.domain.Computer;
import com.gimelle.sandbox.optional.domain.SoundCard;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamInterfaceTest {


    @Test
    public void matchingTest() {

        Supplier<Stream<Long>> supplier = () -> {
            Stream.Builder<Long> b = Stream.builder();
            return b.add(1L).add(2L).add(2L).add(3L).add(4L).add(3L).build();
        };

        assertThat(supplier.get().anyMatch(x -> x > 3), is(true));
        assertThat(supplier.get().anyMatch(x -> x > 7), is(false));

        assertThat(supplier.get().allMatch(x -> x > 0), is(true));
        assertThat(supplier.get().anyMatch(x -> x > 3), is(true));

    }

    @Test
    public void findFirstFindAnyMatchNonTest() {

        Supplier<Stream<Long>> supplier = () -> {
            Stream.Builder<Long> b = Stream.builder();
            return b.add(1L).add(2L).add(2L).add(3L).add(4L).add(3L).build();
        };

        assertThat(supplier.get().findFirst().isPresent(), is(true));
        assertThat(supplier.get().findFirst(), equalTo(Optional.of(1L)));
        assertThat(supplier.get().findAny().isPresent(), is(true));
        assertThat(supplier.get().noneMatch(n -> n > 9L), is(true));
        assertThat(supplier.get().noneMatch(n -> n > 3L), is(false));
    }

    class Averager {

        int count = 0;
        int total = 0;

        public Averager() {
        }

        public double calculeAv() {
            return total / count;
        }

        public void combine(Averager other) {
            count = count + other.count;
            total = total + other.total;
        }

        public void accumulate(int other) {
            count = count + 1;
            total = total + other;
        }
    }

    @Test
    public void collectAndReduceSum() {

        Computer c1 = new Computer("c1").withSoundCard(new SoundCard());
        Computer c2 = new Computer("ctwo").withSoundCard(new SoundCard());
        Computer c3 = new Computer("ctrois").withSoundCard(new SoundCard());

        Supplier<Stream<Computer>> computers = () -> Stream.of(c1, c2, c3);

        int sum = computers.get().mapToInt(c -> c.nickName.length())
                .sum();

        assertThat(
                computers.get().mapToInt(c -> c.nickName.length())
                        .reduce(0, (a, b) -> a + b)
                ,
                equalTo(sum)
        );

        //acculator object
        //accumulating function
        //combine (So can fork join stuff more or less)
        assertThat(
                computers.get().mapToInt(c -> c.nickName.length())
                        .collect(
                                Averager::new,
                                Averager::accumulate,
                                Averager::combine
                        ).calculeAv()
                ,
                equalTo(4.0)
        );

    }

    @Test
    public void testConcatDistinctEmpty() {

        Supplier<Stream<String>> heros = () -> Stream.of("SuperMan", "WonderWoman");
        Supplier<Stream<String>> cars = () -> Stream.of("Axel", "Visa");

        assertThat(
                Stream.concat(heros.get(), cars.get()).collect(Collectors.toList()),
                equalTo(
                        Stream.of("SuperMan", "WonderWoman", "Axel", "Visa").collect(Collectors.toList())
                ));

        assertThat(
                Stream.empty().count(),
                equalTo(0L));

        assertThat(
                Stream.of(1, 2, 2, 3).distinct().collect(Collectors.toList()),
                equalTo(
                        Stream.of(1, 2, 3).collect(Collectors.toList())
                ));
    }


    @Test
    public void testGenerateIterateSkipStream() {

        assertThat(
                Stream.generate(() -> "toto").limit(3).collect(Collectors.toList()),
                equalTo(Stream.of("toto", "toto", "toto").collect(Collectors.toList())));

        Stream.generate(() -> Math.random() + "xx").limit(4).forEach(System.out::println);


        assertThat(
                Stream.iterate(1, n -> n + 2).limit(5).skip(2).collect(Collectors.toList()),
                equalTo(Stream.of(5, 7, 9).collect(Collectors.toList())));
    }

    @Test
    public void testPeek(){

        IntStream.rangeClosed(1,5).forEach(System.out::println);

        IntStream.rangeClosed(1,5)
                .peek(n -> System.out.print(n+"Yo"))
                .peek(n-> System.out.println(n+"Man!"))
                .count();
    }
}
