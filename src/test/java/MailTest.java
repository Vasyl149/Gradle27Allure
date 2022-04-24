import jdk.jfr.Enabled;
import org.testng.annotations.Test;
import page_bo.main_pages.EmailComposePageBO;
import page_bo.main_pages.commonBO.MainMenuBO;

import java.io.FileNotFoundException;


public class MailTest extends BaseTest {
    @Test(description = "New Mail without Recipient")
    public void newMailWithoutRecipientTest() throws InterruptedException, FileNotFoundException {
        int draftsNumber = new MainMenuBO().getDraftsNumber();
//        new MainMenuBO().openComposePage();
        new EmailComposePageBO()
                .createNewMail()
                .verifyStyleEditingElements()
                .verifyFontsInDropdown()
                .addFile()
                .clickUnreadButton();

        int newDraftsNumber = new MainMenuBO().getDraftsNumber();
        new MainMenuBO().verifyDraftsNumber(newDraftsNumber, draftsNumber);

//        new MainMenuBO().draftButton()
//                .verifySendDraft()
//                .sentButton()
//                .verifySentMail();
    }

    @Test(description = "Send draft")
    public void sendDraftTest() throws InterruptedException {
        new MainMenuBO().draftButton()
                .verifySendDraft()
                .sentButton()
                .verifySentMail();
    }
}
