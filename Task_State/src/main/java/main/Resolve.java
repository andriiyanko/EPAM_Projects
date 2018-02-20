package main;

public class Resolve implements TaskState{

    private Task task;

    public Resolve(Task task) {
        this.task = task;
    }

    @Override
    public void close() {
        task.set_state(new Close(task));
        System.out.println("Task was closed");
    }

    @Override
    public void reopen() {
        task.set_state(new Reopen(task));
        System.out.println("Task was reopened.");
    }

}
