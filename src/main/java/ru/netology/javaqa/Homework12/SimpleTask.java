package ru.netology.javaqa.Homework12;

public class SimpleTask extends Task {


    protected int id;
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    public int getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    @Override
    public boolean matches(String query) {
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

}
