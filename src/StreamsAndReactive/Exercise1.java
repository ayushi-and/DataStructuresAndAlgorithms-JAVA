package StreamsAndReactive;

public class Exercise1 {

    public static void main(String[] args) {

        //print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::print);
        System.out.println();

        //print numbers in the intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(i -> i < 5).forEach(System.out::print);
        System.out.println();

        //print the second and third numbers in the intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(i -> i > 5).skip(1).limit(2).forEach(System.out::print);
        System.out.println();

        //print the first number in intNumbersStream that's greater than 5.
        //If nothing is found, print -1
        Integer value = StreamSources.intNumbersStream().filter(i -> i > 5).findFirst().orElse(-1);
        System.out.println(value);
        System.out.println();

        //print first names of all users in userStream
        //StreamSources.userStream().forEach(user -> System.out.print(user.getFirstName()));
        StreamSources.userStream().map(User::getFirstName).forEach(System.out::println);
        System.out.println();

        //print first names in userStream for users that have IDs from numberStreams
        /*StreamSources.intNumbersStream().flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                        .map(user -> user.getFirstName()).forEach(System.out::println);*/
        StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                        .forEach(System.out::println);
        System.out.println();
    }
}
