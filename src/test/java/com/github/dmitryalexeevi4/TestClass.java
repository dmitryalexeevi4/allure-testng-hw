package com.github.dmitryalexeevi4;

import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void calculator() {
        Assert.assertEquals(sum(2, 2), 4);
    }

    @Step
    public float sum(float a, float b) {
        return a + b;
    }
}
