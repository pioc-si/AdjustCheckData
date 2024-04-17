package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:src/main/resources/curl.properties"
})
public interface Props extends Reloadable {
    Props props = ConfigFactory.create(Props.class);

    @Key("browser.size")
    String browserSize();

    @Key("page.load.timeout")
    String pageLoadTimeout();

    @Key("timeout")
    String timeout();


    @Key("bitrixCurl.url")
    String bitrixCurlUrl();

    @Key("bitrixCurl.request.method")
    String bitrixCurlRequestMethod();

    @Key("bitrixCurl.header.authority")
    String bitrixCurlHeaderAuthority();

    @Key("bitrixCurl.header.accept")
    String bitrixCurlHeaderAccept();

    @Key("bitrixCurl.header.accept-language")
    String bitrixCurlHeaderAcceptLanguage();

    @Key("bitrixCurl.header.content-type")
    String bitrixCurlHeaderContentType();

    @Key("bitrixCurl.header.cookie")
    String bitrixCurlHeaderCookie();

    @Key("bitrixCurl.requestBody")
    String bitrixCurlRequestBody();





    @Key("deliverablesCurl.url")
    String deliverablesCurlUrl();

    @Key("deliverablesCurl.header.authority")
    String deliverablesCurlHeaderAuthority();

    @Key("deliverablesCurl.header.accept")
    String deliverablesCurlHeaderAccept();

    @Key("deliverablesCurl.header.accept-language")
    String deliverablesCurlHeaderAcceptLanguage();

    @Key("deliverablesCurl.header.cache-control")
    String deliverablesCurlHeaderCacheControl();

    @Key("deliverablesCurl.header.cookie")
    String deliverablesCurlHeaderCookie();

    @Key("deliverablesCurl.header.correlation-id")
    String deliverablesCurlHeaderCorrelationId();

    @Key("deliverablesCurl.header.origin")
    String deliverablesCurlHeaderOrigin();

    @Key("deliverablesCurl.header.pragma")
    String deliverablesCurlHeaderPragma();

    @Key("deliverablesCurl.header.referer")
    String deliverablesCurlHeaderReferer();

    @Key("deliverablesCurl.header.sec-ch-ua")
    String deliverablesCurlHeaderSecChUa();

    @Key("deliverablesCurl.header.sec-ch-ua-mobile")
    String deliverablesCurlHeaderSecChUaMobile();

    @Key("deliverablesCurl.header.sec-ch-ua-platform")
    String deliverablesCurlHeaderSecChUaPlatform();

    @Key("deliverablesCurl.header.sec-fetch-dest")
    String deliverablesCurlHeaderSecFetchDest();

    @Key("deliverablesCurl.header.sec-fetch-mode")
    String deliverablesCurlHeaderSecFetchMode();

    @Key("deliverablesCurl.header.sec-fetch-site")
    String deliverablesCurlHeaderSecFetchSite();

    @Key("deliverablesCurl.header.user-agent")
    String deliverablesCurlHeaderUserAgent();

    @Key("deliverablesCurl.header.x-referer")
    String deliverablesCurlHeaderXReferer();

    @Key("deliverablesCurl.header.x-source")
    String deliverablesCurlHeaderXSource();



    @Key("nonShopCurl.url1")
    String nonShopCurlUrl1();

    @Key("nonShopCurl.url2")
    String nonShopCurlUrl2();

    @Key("nonShopCurl.header.authority")
    String nonShopCurlHeaderAuthority();

    @Key("nonShopCurl.header.accept")
    String nonShopCurlHeaderAccept();

    @Key("nonShopCurl.header.accept-language")
    String nonShopCurlHeaderAcceptLanguage();

    @Key("nonShopCurl.header.cache-control")
    String nonShopCurlHeaderCacheControl();

    @Key("nonShopCurl.header.cookie")
    String nonShopCurlHeaderCookie();

    @Key("nonShopCurl.header.correlation-id")
    String nonShopCurlHeaderCorrelationId();

    @Key("nonShopCurl.header.origin")
    String nonShopCurlHeaderOrigin();

    @Key("nonShopCurl.header.pragma")
    String nonShopCurlHeaderPragma();

    @Key("nonShopCurl.header.referer")
    String nonShopCurlHeaderReferer();

    @Key("nonShopCurl.header.sec-ch-ua")
    String nonShopCurlHeaderSecChUa();

    @Key("nonShopCurl.header.sec-ch-ua-mobile")
    String nonShopCurlHeaderSecChUaMobile();

    @Key("nonShopCurl.header.sec-ch-ua-platform")
    String nonShopCurlHeaderSecChUaPlatform();

    @Key("nonShopCurl.header.sec-fetch-dest")
    String nonShopCurlHeaderSecFetchDest();

    @Key("nonShopCurl.header.sec-fetch-mode")
    String nonShopCurlHeaderSecFetchMode();

    @Key("nonShopCurl.header.sec-fetch-site")
    String nonShopCurlHeaderSecFetchSite();

    @Key("nonShopCurl.header.user-agent")
    String nonShopCurlHeaderUserAgent();

    @Key("nonShopCurl.header.x-referer")
    String nonShopCurlHeaderXReferer();

    @Key("nonShopCurl.header.x-source")
    String nonShopCurlHeaderXSource();


}