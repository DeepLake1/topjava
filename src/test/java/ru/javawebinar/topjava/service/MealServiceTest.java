package ru.javawebinar.topjava.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.NOT_FOUND;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest extends TestCase {

    @Autowired
    MealService mealService;

    @Test
    public void testGet() {
        Meal meal = mealService.get(MealTestData.MEAL1_ID, UserTestData.USER_ID);
        assertMatch(meal, MealTestData.meal1);
    }

    @Test
    public void testDelete() {
        mealService.delete(MealTestData.MEAL1_ID, UserTestData.USER_ID);
        assertThrows(NotFoundException.class, () -> mealService.get(MEAL1_ID, USER_ID));
    }
    @Test
    public void testDeleteWithWrongUser() {
        assertThrows(NotFoundException.class, () -> mealService.delete(MEAL1_ID, UserTestData.NOT_FOUND));

    }
    @Test
    public void testGetBetweenInclusive() {
        MEAL_MATCHER.assertMatch(mealService.getBetweenInclusive(
                LocalDate.of(2020, Month.JANUARY, 30),
                LocalDate.of(2020, Month.JANUARY, 30), USER_ID),
                meal3, meal2, meal1);
    }

    @Test
    public void testGetAll() {
        List<Meal> meals = mealService.getAll(USER_ID);
        assertMatch(meals, MealTestData.meals);
    }

    @Test
    public void testUpdate() {
        mealService.update(MealTestData.getUpdated(), USER_ID);
        assertMatch(mealService.get(MEAL1_ID, USER_ID), getUpdated());
    }

    @Test
    public void testCreate() {
        Meal meal = mealService.create(MealTestData.getNew(), UserTestData.USER_ID);
        System.out.println(meal);
    }

    @Test
    public void testGetMealWithWrongUser() {
        assertThrows(NotFoundException.class, () -> mealService.get(MEAL1_ID, UserTestData.NOT_FOUND));
    }
    @Test
    public void testUpdateWithWrongUser(){
        assertThrows(NotFoundException.class, () -> mealService.update(getUpdated(), UserTestData.NOT_FOUND));

    }
}