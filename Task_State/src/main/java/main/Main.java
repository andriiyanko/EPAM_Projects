package main;

public class Main {

    public static void main(String[] args) {
        Task taskFlow = new Task();
        taskFlow.open();
        taskFlow.assign();
        taskFlow.reopen();
        taskFlow.resolved();
        taskFlow.close();
    }
}
