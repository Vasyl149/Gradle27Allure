import page_bo.main_pages.commonBO.MainMenuBO;

import java.io.FileNotFoundException;


public class MailTest extends BaseTest {
    //@Test
    public void newMailWithoutRecipientTest() throws InterruptedException, FileNotFoundException {
        int draftsNumber = new MainMenuBO().getDraftsNumber();
        new MainMenuBO().openComposePage().
                createNewMail().
                verifyStyleEditingElements().
                verifyFontsInDropdown().
                addFile().
                clickUnreadButton();

        int newDraftsNumber = new MainMenuBO().getDraftsNumber();
        new MainMenuBO().verifyDraftsNumber(newDraftsNumber, draftsNumber);

        new MainMenuBO().draftButton().
                verifySendDraft().
                sentButton().
                verifySentMail();

    }

}
