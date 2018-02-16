package com.sagar.retb;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import android.support.test.*;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.*;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RetBIntentTestTest {
    private static final String MESSAGE = "This is a test";
    private static final String PACKAGE_NAME = "com.sagar.RetB";

    @Rule
    public IntentsTestRule<WelcomeToShop> mIntentsRule = new IntentsTestRule<>(WelcomeToShop.class);

    @Test
    public void verifyOpeningOfLaptopActivity() {

        onView(withId(R.id.txtLaptop)).perform(click());
    }

}