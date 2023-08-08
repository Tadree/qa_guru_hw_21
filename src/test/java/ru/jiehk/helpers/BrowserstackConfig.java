package ru.jiehk.helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/base.properties",
        "classpath:config/${env}.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("user")
    @DefaultValue("bsuser_JSwAUo")
    String getUser();

    @Key("key")
    @DefaultValue("PgfYVaTjLqqsfixeYaFJ")
    String getKey();

    @Key("baseUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getBaseUrl();

    @Key("app")
    @DefaultValue("bs://sample.app")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("osVersion")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("project")
    @DefaultValue("First Java Project")
    String getProject();

    @Key("build")
    @DefaultValue("browserstack-build-1")
    String getBuild();

    @Key("name")
    @DefaultValue("first_test")
    String getName();
}
