package ru.netology.javaqa.Homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test

    public void testMeetingFalseTopic() {

        Meeting test = new Meeting(1, "Домашние дела", "Выгулять собаку", "Вечером");

        boolean expected = false;

        boolean actual = test.matches("Список дел");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingTrueTopic() {

        Meeting test = new Meeting(1, "Домашние дела", "Выгулять собаку", "Вечером");

        boolean expected = true;

        boolean actual = test.matches("Домашние дела");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMeetingTrueProject() {

        Meeting test = new Meeting(1, "Домашние дела", "Выгулять собаку", "Вечером");

        boolean expected = true;
        boolean actual = test.matches("Выгулять собаку");

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testMeetingFalseProject() {

        Meeting test = new Meeting(1, "Домашние дела", "Выгулять собаку", "Вечером");

        boolean expected = false;
        boolean actual = test.matches("Помыть кошку");

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testSimpleTaskTitleTrue() {

        SimpleTask task = new SimpleTask(2, "Сходить в спортзал");

        boolean expected = true;
        boolean actual = task.matches("Сходить в спортзал");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testSimpleTaskTitleFalse() {

        SimpleTask task = new SimpleTask(3, "Сходить в спортзал");

        boolean expected = false;
        boolean actual = task.matches("Сходить в бассейн");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testEpicTasksTrue() {

        String[] subtasks = {
                "Сходить в спортзал",
                "Сходить в бассейн",
                "Сходить в магазин",
                "Выгулять собаку",
                "Помыть кошку",
                "Покормить хомячка"};

        Epic task = new Epic(33, subtasks);

        boolean expected = true;
        boolean actual = task.matches("Покормить хомячка");

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void testEpicTasksFalse() {

        String[] subtasks = {
                "Сходить в спортзал",
                "Сходить в бассейн",
                "Сходить в магазин",
                "Выгулять собаку",
                "Помыть кошку",
                "Покормить хомячка"};

        Epic task = new Epic(34, subtasks);

        boolean expected = false;
        boolean actual = task.matches("Кататься на велосипеде");

        Assertions.assertEquals(actual, expected);
    }

}
