package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface Configuration extends Config {
    @Key("url")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("testemail")
    String testemail();

    @Key("message")
    String message();

    @Key("testFilePath")
    String testFilePath();

    @Key("menuFilePath")
    String menuListFilePath();




}