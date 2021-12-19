package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreenADV{
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container' and @class = 'android.widget.FrameLayout']")
    List<MobileElement> list;


    public SwipeableBasicScreen swipeFromLeftToRight() {
        System.out.println(list.size());
        MobileElement element = list.get(0);
        Rectangle rect = element.getRect();
        System.out.println(rect.getWidth());

        int xFrom= rect.getX() + (rect.getWidth()/10)*2;
        int y = rect.getY()+ rect.getHeight()/2;

        int xTo = rect.getX() + (rect.getWidth()/10)*9;

        TouchAction<?> action = new TouchAction<>(driver);

        action.longPress(PointOption.point(xFrom,y ))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();

        return this;
    }

    public SwipeableBasicScreen swipeFromRightToLeft(){
        MobileElement el = list.get(3);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX() + (rect.getWidth()-20);
        int y = rect.getY()+ rect.getHeight()/2;
        int xTo = rect.getX()+20;

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xFrom,y))
                .moveTo(PointOption.point(xTo,y))
                .release()
                .perform();

        return this;
    }

}
