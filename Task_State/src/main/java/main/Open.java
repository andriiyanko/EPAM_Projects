package main;

public class Open implements TaskState {

    private Task task;

    public Open(Task task) {
        this.task = task;
    }

    @Override
    public void resolved() {
            task.set_state(new Resolve(task));
            System.out.println("Task was resolved.");
    }

    @Override
    public void assign() {
        task.setIs_Assign(true);
        System.out.println("Task assigned.");
    }
}
