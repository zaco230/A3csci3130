package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.actionWithAssertions;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    String name, number, business, address, prov;

    @Rule
    public ActivityTestRule<MainActivity> myActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setStrings()
    {
        name = "Test for CSCI3130";
        number = "313031303";
        business = "Fisher";
        address = "1234 Test Drive";
        prov = "NS";
    }

    /**
     * Test for creating a contact
     * @throws Exception
     */
    @Test
    public void createContact() throws Exception
    {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.number)).perform(typeText(number));
        onView(withId(R.id.business)).perform(typeText(business));
        onView(withId(R.id.address)).perform(typeText(address));
        onView(withId(R.id.province)).perform(typeText(prov));
        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * Test for updating a business contact's information
     * @throws Exception
     */
    @Test
    public void update() throws Exception
    {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.number)).perform(typeText(number));
        closeSoftKeyboard();
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * Test for deleting a business contact
     * @throws Exception
     */
    @Test
    public void delete() throws Exception
    {
        onView(withId(R.id.listView)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.deleteButton)).perform(click());
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
}
