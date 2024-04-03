package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/test.properties"
})
public interface Props extends Reloadable {
    Props props = ConfigFactory.create(Props.class);

    @Key("adjustUrl")
    String adjustUrl();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("browser.size")
    String browserSize();

    @Key("page.load.timeout")
    String pageLoadTimeout();

    @Key("timeout")
    String timeout();

    @Key("inputFile")
    String inputFile();

    @Key("checkFile")
    String checkFile();

    @Key("uniqueInstallsCellPosition")
    int uniqueInstallsCellPosition();


}