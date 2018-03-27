package com.packt.madev.portfolio.addnew;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.packt.madev.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddNewStockActivityTest {
    @Rule
    public ActivityTestRule<AddNewStockActivity> mActivityRule =
            new ActivityTestRule(AddNewStockActivity.class);

    @Test
    public void no_of_shares_field_is_displayed() {
        onView(withText("No. of shares")).check(matches(isDisplayed()));
    }

    @Test
    public void there_should_be_some_default_value_for_symbol_name() {
        onView(withId(R.id.portfolio_addnew_symbol)).check(matches(withText("GOOG")));
    }
}