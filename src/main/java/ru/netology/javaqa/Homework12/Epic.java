package ru.netology.javaqa.Homework12;

public class Epic extends Task {


    protected int id;
    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public int getId() {

        return id;
    }

    public String[] getSubtasks() {

        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String result : subtasks) {
            if (result.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
