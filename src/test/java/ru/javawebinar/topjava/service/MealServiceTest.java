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

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest extends TestCase {

    @Autowired
    MealService mealService;

    @Test
    public void testGet() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testGetBetweenInclusive() {
    }

    @Test
    public void testGetAll() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testCreate() {
        Meal meal = mealService.create(MealTestData.getNew(), UserTestData.USER_ID);
        System.out.println(meal);
    }
}