package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("username")
    String username();

    @Key("accessKey")
    String accessKey();

    @Key("appUrl")
    String appUrl();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("videoUrl")
    String videoUrl();
}