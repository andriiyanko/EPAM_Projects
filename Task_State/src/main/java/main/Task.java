package main;

public class Task {

    private TaskState _state;
    private boolean is_Assign;

    public Task(){
        this._state = new Open(this);
        this.is_Assign = false;
    }

    public void open(){
        _state.open();
    }

    public void resolved(){
        _state.resolved();
    }

    public void reopen(){
        _state.reopen();
    }

    public void close(){
        _state.close();
    }

    public void assign(){
        _state.assign();
    }

    public void setIs_Assign(boolean is_Assign) {
        this.is_Assign = is_Assign;
    }

    public TaskState get_state() {
        return _state;
    }

    public void set_state(TaskState _state) {
        this._state = _state;
    }
}
