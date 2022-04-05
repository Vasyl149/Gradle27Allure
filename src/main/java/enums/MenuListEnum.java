package enums;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public enum MenuListEnum {
    INBOX("Вхідні"),
    DRAFTS("Чернетки"),
    SENT("Надіслані"),
    SPAM("Спам"),
    TRASH("Видалені"),
    UNREAD("Непрочитані"),
    MARKED("Відмічені"),
    FILES("Вкладення");

    private final String value;

    MenuListEnum(String value) {
        this.value = value;
    }

    public static List<String> getNamesOfItems() throws UnsupportedEncodingException {

        List<String> namesOfItems = new ArrayList<>();
        for (MenuListEnum item : MenuListEnum.values()) {
            namesOfItems.add(item.toUTF8());
        }
        return namesOfItems;
    }

    public String toUTF8() throws UnsupportedEncodingException {
        byte[] _byte = value.getBytes();
        String str = new String(_byte, "UTF-8");
        return str;
    }




    @Override
    public String toString() {
        return value;
    }
}
