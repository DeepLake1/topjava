package ru.javawebinar.topjava;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.HashMap;
import java.util.Map;

public class RuleForTest implements TestRule {
    private static Map<String, Long> allTestsTime = new HashMap<>();
    private long timeForTestStart;

    public Map<String, Long> getAllTestsTime() {
        return allTestsTime;
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                timeForTestStart = System.currentTimeMillis();
                base.evaluate();
                long timeForTestTotal = System.currentTimeMillis() - timeForTestStart;
                allTestsTime.put(description.getClassName(), timeForTestTotal);
                System.out.println("--------Method name: >" + description.getMethodName() + "< completed in " + timeForTestTotal +"ms --------");
            }
        };

    }


}
