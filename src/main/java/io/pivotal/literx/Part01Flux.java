package io.pivotal.literx;

import org.assertj.core.util.Lists;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

    // TODO Return an empty Flux
    Flux<String> emptyFlux() {
        return Flux.empty();
    }

//========================================================================================

    // TODO Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
    Flux<String> fooBarFluxFromValues() {
        return Flux.fromStream(Stream.of("foo", "bar"));
    }

//========================================================================================

    // TODO Create a Flux from a List that contains 2 values "foo" and "bar"
    Flux<String> fooBarFluxFromList() {
        return Flux.fromIterable(Lists.newArrayList("foo", "bar"));
    }

//========================================================================================

    // TODO Create a Flux that emits an IllegalStateException
    Flux<String> errorFlux() {
        final Flux<String> stringFlux = fooBarFluxFromValues();
        stringFlux.toIterable().forEach(String::toUpperCase);
        return stringFlux;
    }

//========================================================================================

    // TODO Create a Flux that emits increasing values from 0 to 9 each 100ms
    Flux<Long> counter() {
        return Flux.fromStream(Stream.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
    }

}
