package main;

public class Close implements TaskState {

    private Task task;

    public Close(Task task) {
        this.task = task;
    }

    @Override
    public void reopen() {
        task.set_state(new Reopen(task));
        System.out.println("Task was reopened.");
    }
}
