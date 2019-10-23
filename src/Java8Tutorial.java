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
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * name
 * parameter list
 * body
 * return type
 */

/**
 * Parking lot
 * Lazy evalutation
 * Lazy initialization
 * function composition
 * method referrence
 * pure function
 * Side - effects
 *
 */

interface WhaleJump {
    void jump(String name);
    void swim(String name);
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
    static IntStream numberStream = IntStream.range(1, 90);


    public static int total(List<Integer> numbers,  Predicate<Integer> selector)  {
        return numbers.stream().filter(selector).mapToInt(e -> e).sum();
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


    static class Job {


        String title;
        String city;
        String state;
        String company;

        public Job() {
        }

        public Job(String title, String city, String state, String company) {
            this.title = title;
            this.city = city;
            this.state = state;
            this.company = company;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "title='" + title + '\'' +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", company='" + company + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4, 5, 6, 7, 8);
        List<Job> jobsList = new ArrayList<>();
        jobsList.add(new Job("JAVA Developer", "Mumbai", "Maharastra", "Crossasyst"));
        jobsList.add(new Job("React JS", "Mumbai", "Maharastra", "Crossasyst"));
        jobsList.add(new Job("SQL", "PUNE", "Maharastra", "Crossasyst"));
        jobsList.add(new Job("Spring boot", "NANDED", "Maharastra", "Crossasyst"));
        jobsList.add(new Job("QA Engineer", "Banglore", "KARNATAKA", "Accenture"));

        List<Job> mumbaiJobs = jobsList.stream().filter(job -> job.getCity().equals("Mumbai")).collect(Collectors.toList());
        Job mumbaiJob = jobsList.stream().filter(job -> job.getCity().equals("Mumbai")).findFirst().filter(job -> !job.getCompany().equals("Crossasyst")).get();
        System.out.println(Objects.requireNonNull(mumbaiJob).getTitle());
        Optional<Job> optionalJob = Optional.of(new Job("React JS", "Belgaum", "Maharashtra", "ABC"));

        Job reactJSMumbai = mumbaiJobs.stream().filter(job -> job.getTitle().equals(optionalJob.get().getTitle())).findFirst().orElseGet(null);

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

        animal.setWhalJump(new WhaleJump() {
            @Override
            public void jump(String name) {

            }

            @Override
            public void swim(String name) {

            }
        });
        System.out.println(total(numbers, integer -> integer % 2 == 0));
        System.out.println(total(numbers, integer -> true));

        ArrayList<Integer> arraylist= new ArrayList<>();
        arraylist.add(5);
        arraylist.add(7);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(4);
        arrayList1.add(9);

        arraylist.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        arraylist.forEach(System.out::println);

        arraylist.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 4;
            }
        }).collect(Collectors.toList());


        List<Integer> numbersGreTHanFOur = arraylist.stream().filter((e-> e > 4)).collect(Collectors.toList());
        numbersGreTHanFOur.forEach((System.out::println));

        BiConsumer<List<Integer>, List<Integer>> equals = (integers, integers2) -> {
            if (integers.size() != integers2.size()) {
                System.out.println("False");
            } else {
                for (int i = 0; i < arrayList1.size(); i++) {
                    if (!integers.get(i).equals(integers2.get(i))) {
                        System.out.println("False");
                        return;
                    }
                }
                System.out.println("True");
            }
        };

        equals.andThen((integers, integers2) -> {
            integers.forEach(e -> System.out.print(e + " "));
            System.out.println();
            integers2.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }).accept(arraylist, arrayList1);

    }
}
