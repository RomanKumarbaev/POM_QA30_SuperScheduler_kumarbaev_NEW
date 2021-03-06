package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeScreen extends BaseScreen{
    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
@FindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_main']")
MobileElement fabAdd;
    @FindBy(xpath = "//*[@resource-id = 'com.example.svetlana.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;
    @FindBy(xpath = "//*[@content-desc='Open']")
    MobileElement burgerBtn;
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/nav_fr_logout']")
    MobileElement logout;



    public boolean isFabAddPresent(){

        should(fabAdd,20);

        return fabAdd.isDisplayed();
    }

    public EditCreateEventScreen initCreationEvent(){

        fabAdd.click();
        fabAddEvent.click();

        return new EditCreateEventScreen(driver);

    }

    public HomeScreen isFabAddPresentAssert(){
        should(fabAdd,20);
        Assert.assertTrue(fabAdd.isDisplayed());
        return this;
    }

    public HomeScreen openMenu(){
        burgerBtn.click();
        return this;
    }

    public LoginScreen logOut(){
        logout.click();

        return new LoginScreen(driver);
    }




}
