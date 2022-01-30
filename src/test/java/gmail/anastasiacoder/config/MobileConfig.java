package gmail.anastasiacoder.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({"classpath:mobile.properties"})
public interface MobileConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("url")
    String url();
}