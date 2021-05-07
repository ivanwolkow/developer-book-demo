package com.example.demo.java.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.google.common.util.concurrent.Uninterruptibles.*;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectionsTest {

    @Test
    void arrayListTest() {
        ArrayList<Object> objects = new ArrayList<>();

        objects.add(new Object());
        objects.add(0, new Object());
        objects.remove(1);
        boolean contains = objects.contains(1);

        ImmutableList<Object> immutableList = ImmutableList.builder()
                .add("ping")
                .add("pong")
                .build();

        List<Object> immutableCopy = List.copyOf(new ArrayList<>());
        List<Integer> integerImmutableList = List.of(1, 2, 3);
    }

    @Test
    void linkedListTest() {
        LinkedList<String> ll = new LinkedList<>();
        ll.push("first1"); //push element in front of the list
        ll.addFirst("first2"); //same as push
        ll.offer("last1");  //append element to the end of list
        ll.addLast("last2"); //same as offer but return void

        ll.removeFirstOccurrence("last2"); // find and remove element (by traversing from head to tail)
        System.out.println("polled: " + ll.poll());  //retrieve and remove
        System.out.println("peeked: " + ll.peek()); //retrieve without removing
        System.out.println(ll);
    }


    @Test
    void linkedHashMap() {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put(2, "2");
        map.put(30, "30");
        map.put(5, "5");
        map.remove(30);

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    @Test
    void treeMapComparatorContractTest() {
        TreeMap<String, Object> map = new TreeMap<>(Comparator.comparingInt(String::length));

        map.put("aaa", "aaa");
        map.put("b", "b");
        map.put("cccc", "cccc");
        map.put("dddd", "dddd");

        map.forEach((key, value) -> System.out.println(key + ":" + value));
        assertEquals("dddd", map.get("qwer"));
    }

    @Test
    void treeSetTest() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(12);
        System.out.println(treeSet);
    }

    @Test
    void nonConcurrentHashMapTest() throws ExecutionException {
        var DUMMY = new Object();
        var map = new HashMap<Integer, Object>();

        var executorService = Executors.newFixedThreadPool(4);

        CompletableFuture[] completableFutures = IntStream.range(0, 10000)
                .mapToObj(i -> CompletableFuture.runAsync(() -> map.put(i, DUMMY), executorService))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures)
                .join();

        System.out.println("map size: " + map.size());

        executorService.shutdown();
        Uninterruptibles.awaitTerminationUninterruptibly(executorService);
    }

    @Test
    void concurrentCollections() {
        ConcurrentHashMap<Object, Object> concHashMap = new ConcurrentHashMap<>();

        Set<Object> concHashSet = Collections.newSetFromMap(new ConcurrentHashMap<>());
        Set<Object> concHashSet2 = Sets.newConcurrentHashSet(); //the same as above
    }

    @Test
    void synchronizedCollections() {
        Map<Object, Object> syncHashMap = Collections.synchronizedMap(new HashMap<>());
        Map<Object, Object> syncLinkedMap = Collections.synchronizedMap(new LinkedHashMap<>());
        Map<Object, Object> syncWeakHashMap = Collections.synchronizedMap(new WeakHashMap<>());
        SortedMap<Object, Object> syncSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

        Set<Object> syncHashSet = Collections.synchronizedSet(new HashSet<>());
        Set<Object> syncLinkedHashSet = Collections.synchronizedSet(new LinkedHashSet<>());
        SortedSet<Object> syncSortedSet = Collections.synchronizedSortedSet(new TreeSet<>());

        List<Object> syncList = Collections.synchronizedList(new ArrayList<>());
    }

    @Test
    void linkedList() {
        LinkedList<Object> linkedList = Stream.generate(Object::new)
                .limit(10)
                .collect(Collectors.toCollection(LinkedList::new));

        linkedList.push(new Object());
        Object first = linkedList.pollFirst();
        Object last = linkedList.pollLast();
    }

    @Test
    void priorityBlockingQueue() {
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(128);

        priorityBlockingQueue.add(1);
        priorityBlockingQueue.add(500);
        priorityBlockingQueue.add(421);
        priorityBlockingQueue.add(52);

        assertEquals(1, priorityBlockingQueue.poll());
        assertEquals(52, priorityBlockingQueue.poll());
        assertEquals(421, priorityBlockingQueue.poll());
        assertEquals(500, priorityBlockingQueue.poll());
    }

    @Test
    void synchronousBlockingQueue() {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {  //receiving thread
            while (true) {
                System.out.println("Receiving thread is ready!");
                String msg = takeUninterruptibly(synchronousQueue);
                System.out.println("Received: " + msg + ", emulating unavailability...");
                sleepUninterruptibly(3, SECONDS);
            }
        }).start();

        System.out.println("Sending first message...");
        putUninterruptibly(synchronousQueue, "First message");

        System.out.println("Sending second message...");
        //will block until the reading thread takes the first message out of the queue
        putUninterruptibly(synchronousQueue, "Second message");

        System.out.println("Sending third message...");
        //will block until the reading thread takes the second message out of the queue
        putUninterruptibly(synchronousQueue, "Third message");
    }
}
