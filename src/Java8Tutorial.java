/**
 * Whats new in java 8
 * Lambda expression -- Completed
 * Method Referrences --
 * Functional Interfaces --
 * Streams --
 * Optional class --
 * Functional programming. / OOPS
 */


// Consumer
// Predicate
// BiConsumer
// BiPredicate
//Function

// How is a function defined in java

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * name
 * parameter list
 * body
 * return type
 */

@FunctionalInterface
interface WhaleJump {
    void jump(String name);
}

class Mammal {
    private String species;

    Mammal() {

    }
    public Mammal(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    void setSpecies(String species) {
        this.species = species;
    }
}

class Animal  extends Mammal {

    public Animal() {
        super();
        this.setSpecies("Whales");
    }

    public void setWhalJump(WhaleJump jump) {
        jump.jump("Whale");
    }
}

public class Java8Tutorial {

    private static Consumer<String> printer = System.out::println;
    private static Consumer<Integer> printerInt = System.out::println;

    public static List<Integer> total(List<Integer> numbers,  Predicate<Integer> selector)  {
        return numbers.stream().filter(selector).collect(Collectors.toList());
    }

    public static Integer totalEven(List<Integer> numbers)  {
        int result = 0;
        for (Integer e: numbers) {
            result += e;
        }
        return result;
    }

    public static Integer totalOdd(List<Integer> numbers)  {
        int result = 0;
        for (Integer e: numbers) {
            if (e % 2 != 0) {
                result += e;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4, 5, 6, 7, 8);
//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
        numbers.forEach(printerInt);
        final Animal animal = new Animal();
//        animal.setWhalJump(new WhaleJump() {
//            @Override
//            public void jump(String name) {
//
//            }
//        });

        animal.setWhalJump((name) -> System.out.println(name + "  jumps"));
        System.out.println(total(numbers, integer -> integer % 2 == 0));
        System.out.println(total(numbers, integer -> true));
    }
}
