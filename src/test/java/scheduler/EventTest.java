package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;

public class EventTest extends ConfigurationScheduler {

    @BeforeMethod
    public void preCondition(){
        new LoginScreen(driver)
                .loginComplex(Auth.builder().email("telranrk25@gmail.com").password("Tlrk12345$").build())
                .skipWizard()
                .isFabAddPresent();
    }

    @Test
    public void createNewEventTest(){

        boolean isLoginPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Event")
                        .type("New")
                        .breaks(2)
                        .wage(50).build())
                .isFabAddPresentAssert()
                .openMenu()
                .logOut()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginPresent);
    }
}
