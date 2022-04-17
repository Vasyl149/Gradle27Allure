import listeners.ListenerTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_bo.main_pages.InboxPageBO;
import page_bo.main_pages.commonBO.MainMenuBO;

import java.io.UnsupportedEncodingException;

//@Listeners(ListenerTest.class)

public class LeftMenuTest extends BaseTest {
    @Test
    public void menuListTest2() throws InterruptedException, UnsupportedEncodingException {
        //System.out.println(driver.getTitle());


        int unreadLetters = new InboxPageBO().
                verifyUnreadLettersPresent().
                getUnreadLettersNumber();

        new MainMenuBO().verifyInboxIsSelected()
                .verifyNavigationMenu().
                verifyUnreadLettersNumber(unreadLetters);

    }

}
