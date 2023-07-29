package pl.refactoring.todo.procedural;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Queue;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VavrTest {
    @Test
    void name() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(Integer.valueOf(1), list.head());
        assertEquals(list.tail(), List.of(2, 3, 4, 5, 6));
        assertEquals(list.prepend(0), List.of(0, 1, 2, 3, 4, 5, 6));
    }

    @Test
    public void queueTest() {
        Queue<Integer> queue = Queue.of(1, 2)
                .enqueue(3)
                .enqueue(4);

        assertEquals(queue, Queue.of(1, 2, 3, 4));
    }

    @Test
    public void queueTest2() {
        Queue<Integer> queue = Queue.of(1, 2);

        Tuple2<Integer, Queue<Integer>> dequeue = queue.dequeue();

        assertEquals(Integer.valueOf(1), dequeue._1());
        assertEquals(Queue.of(2), dequeue._2());
        assertEquals(Queue.of(1, 2), queue);
    }

    @Test
    public void optionalTest() {
        Option<String> possibleNullText = Option.of(null);

        assertTrue(possibleNullText.isEmpty());
        assertEquals("alternative", possibleNullText.getOrElse("alternative"));
    }

    @Test
    public void optionalTest2() {
        String someText = Option.of("alternative text")
                .map(String::toUpperCase)
                .getOrElse("another solution");

        assertEquals("ALTERNATIVE TEXT", someText);
    }
}
