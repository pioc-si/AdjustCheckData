package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/locators.properties"
})
public interface locatorsProps extends Reloadable {
    locatorsProps props = ConfigFactory.create(locatorsProps.class);

    @Key("menuDatascapeButton")
    String menuDatascapeButton();

    @Key("reportsButton")
    String reportsButton();

    @Key("deliverablesReport")
    String deliverablesReport();

    @Key("lichiStoreButton")
    String lichiStoreButton();

    @Key("thisMonthButton")
    String thisMonthButton();

    @Key("lastMonthButton")
    String lastMonthButton();

    @Key("applyDateButton")
    String applyDateButton();

    @Key("reloadDataButton")
    String reloadDataButton();

    @Key("correctDate")
    String correctDate();

    @Key("bitrixWebTable")
    String bitrixWebTable();

    @Key("homeBitrixWebTable")
    String homeBitrixWebTable();

    @Key("datePickerButton")
    String datePickerButton();

    @Key("lastMonthDateButton")
    String lastMonthDateButton();

    @Key("days")
    String days();

    @Key("userData")
    String userData();
}
