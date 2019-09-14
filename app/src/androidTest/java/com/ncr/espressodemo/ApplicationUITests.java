package com.ncr.espressodemo;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ApplicationUITests {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testIncrementButton() {
        for (int i = 0; i < 5; i++) {
            onView(withId(R.id.increment_btn)).perform(click());
        }
        onView(withId(R.id.number_tv)).check(matches(withText("5")));
    }

    @Test
    public void testDecrementButton() {
        for (int i = 0; i < 5; i++) {
            onView(withId(R.id.decrement_btn)).perform(click());
        }
        onView(withId(R.id.number_tv)).check(matches(withText("-5")));
    }

    @Test
    public void testActivityAdvanceButtonPositive() {
        //Check incrementing functionality
        for (int i = 0; i < 10; i++) {
            onView(withId(R.id.increment_btn)).perform(click());
        }
        onView(withId(R.id.number_tv)).check(matches(withText("10")));

        //Check ScrollActivity functionality
        onView(withId(R.id.ready_btn)).perform(click());
        onView(withId(R.id.scrollView)).perform(swipeUp());
        onView(withId(R.id.last_view)).check(matches(isDisplayed()));
    }

    @Test
    public void testActivityAdvanceButtonNegative() {
        //Check decrementing functionality
        for (int i = 0; i < 10; i++) {
            onView(withId(R.id.decrement_btn)).perform(click());
        }
        onView(withId(R.id.number_tv)).check(matches(withText("-10")));

        //Check ScrollActivity functionality
        onView(withId(R.id.ready_btn)).perform(click());
        onView(withId(R.id.scrollView)).perform(swipeUp());
        onView(withId(R.id.last_view)).check(matches(isDisplayed()));
    }
}
