package main;

public interface TaskState {

    default void open() {
        System.out.println("Opening task not allowed");
    }

    default void assign() {
        System.out.println("Assigning task not allowed");
    }

    default void resolved() {
        System.out.println("Resolving task not allowed");
    }

    default void reopen() {
        System.out.println("Reopening task not allowed");
    }

    default void close() {
        System.out.println("Closing task not allowed");
    }


}
