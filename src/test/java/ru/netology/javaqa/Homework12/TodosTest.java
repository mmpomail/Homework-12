package ru.netology.javaqa.Homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryTestSimpleThreeTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить коллегам");
        SimpleTask simpleNext = new SimpleTask(6, "Позвонить другу");
        SimpleTask simpleMore = new SimpleTask(7, "Позвонить другу");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleNext);
        todos.add(simpleMore);

        Task[] expected = {simpleNext, simpleMore};
        Task[] actual = todos.search("Позвонить другу");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryTestSimpleOneTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить коллегам");
        SimpleTask simpleNext = new SimpleTask(6, "Позвонить другу");
        SimpleTask simpleMore = new SimpleTask(7, "Позвонить девушке");

        Todos todos = new Todos();

        todos.add(simpleMore);

        Task[] expected = {simpleMore};
        Task[] actual = todos.search("Позвонить девушке");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryTestSimpleNoneTask() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить коллегам");
        SimpleTask simpleNext = new SimpleTask(6, "Позвонить другу");
        SimpleTask simpleMore = new SimpleTask(7, "Позвонить девушке");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(simpleNext);
        todos.add(simpleMore);

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить маме");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeetingThreeTasks() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meetingNext = new Meeting(
                555,
                "Выезд за город",
                "Велосипедная прогулка в лесу",
                "Утром в субботу"
        );

        Meeting meetingMore = new Meeting(
                555,
                "Выезд за город",
                "Велосипедная прогулка в лесу",
                "Утром в субботу"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meetingNext);
        todos.add(meetingMore);

        Task[] expected = {meetingNext, meetingMore};
        Task[] actual = todos.search("Велосипедная прогулка в лесу");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeetingOneTask() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meetingNext = new Meeting(
                555,
                "Поход в пивбар",
                "Чешский пивбар в центре",
                "Вечером в пятницу"
        );

        Meeting meetingMore = new Meeting(
                555,
                "Выезд за город",
                "Велосипедная прогулка в лесу",
                "Утром в субботу"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meetingNext);
        todos.add(meetingMore);

        Task[] expected = {meetingNext};
        Task[] actual = todos.search("Поход в пивбар");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeetingNoneTask() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meetingNext = new Meeting(
                555,
                "Поход в пивбар",
                "Чешский пивбар в центре",
                "Вечером в пятницу"
        );

        Meeting meetingMore = new Meeting(
                555,
                "Выезд за город",
                "Велосипедная прогулка в лесу",
                "Утром в субботу"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(meetingNext);
        todos.add(meetingMore);

        Task[] expected = {};
        Task[] actual = todos.search("Еженедельный апдейт приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryEpicThreeTasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Epic epicNext = new Epic(56, subtasks);
        Epic epicMore = new Epic(57, subtasks);


        Todos todos = new Todos();
        todos.add(epic);
        todos.add(epicNext);
        todos.add(epicMore);

        Task[] expected = {epic, epicNext, epicMore};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryEpicOneTasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] subtasksNext = {"Помидоры", "Огурцы", "Лук"};
        Epic epicNext = new Epic(56, subtasksNext);

        String[] subtasksMore = {"Макароны", "Гречка", "Пшено"};
        Epic epicMore = new Epic(57, subtasksMore);


        Todos todos = new Todos();
        todos.add(epic);
        todos.add(epicNext);
        todos.add(epicMore);

        Task[] expected = {epicMore};
        Task[] actual = todos.search("Пшено");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryEpicNoneTasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        String[] subtasksNext = {"Помидоры", "Огурцы", "Лук"};
        Epic epicNext = new Epic(56, subtasksNext);

        String[] subtasksMore = {"Макароны", "Гречка", "Пшено"};
        Epic epicMore = new Epic(57, subtasksMore);


        Todos todos = new Todos();
        todos.add(epic);
        todos.add(epicNext);
        todos.add(epicMore);

        Task[] expected = {};
        Task[] actual = todos.search("Картошка");
        Assertions.assertArrayEquals(expected, actual);
    }


}
