package com.gimelle.sandbox.javaeight;

import com.gimelle.sandbox.optional.domain.Computer;
import com.gimelle.sandbox.optional.domain.SoundCard;
import com.gimelle.sandbox.optional.domain.USB;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/*
 * Some optional inspired by http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html and the fluent interface
 * https://www.mkyong.com/java8/java-8-optional-in-depth/
 * */
public class OptionalsTest {

    @Test
    public void haveFunWithOptionals() {

        Computer c1 = new Computer("c1");

        Computer c2 = new Computer("c2")
                .withSoundCard(new SoundCard());

        Computer c3 = new Computer("c3")
                .withSoundCard(
                        new SoundCard().withUsb(
                                new USB().withVersion("1.0")
                        )
                );

        Computer c4 = new Computer("c4")
                .withSoundCard(
                        new SoundCard().withUsb(
                                new USB().withVersion("2.0")
                        )
                );

        Computer c5 = new Computer("c5")
                .withSoundCard(
                        new SoundCard().withUsb(
                                new USB().withVersion("2.0")
                        )
                );

        List<Computer> computers = Arrays.asList(c1, c2, c3, c4, c5);

        computers.stream().map(Computer::getSoundCard).forEach(System.out::println);

        assertThat(computers.size(), equalTo(5));

        computers.stream()
                .map(Computer::getSoundCard).forEach(System.out::println);

        computers.stream().flatMap(e -> Stream.of(e.getSoundCard())).forEach(System.out::println);

        computers.stream()
                .map(Computer::getSoundCard);
        //.filter(e -> e)
        //.map(e -> e.)


        Optional<Computer> computero = Optional.of(c5);
        String version = computero
                .flatMap(Computer::getSoundCard)
                .flatMap(SoundCard::getUsb)
                .map(USB::getVersion).orElse("Unknown");

        System.out.println("version>" + version);

        //Do not mix map and flatmap for stream an optional
        // map  for optional and stream is taking a A to B function
        // flatmap on stream is taking a A to Stream function
        // flatmap on optional is taking an A to Optional function

        Optional<Computer> co = computero.filter(c -> !c.getSoundCard().isPresent());
        assertThat(co.isPresent(), equalTo(false));

        Optional<Computer> noUsbComputer = Optional.ofNullable(c2);

        assertThat(
                noUsbComputer
                        .flatMap(Computer::getSoundCard)
                        .flatMap(SoundCard::getUsb)
                        .orElseGet(() -> new USB().withVersion("0.0")).getVersion(),
                equalTo("0.0"));


        assertThat(computero.get().hashCode(), equalTo(computero.hashCode()));

    }

}
