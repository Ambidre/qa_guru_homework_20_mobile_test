package gmail.anastasiacoder.helpers;

import static io.restassured.RestAssured.given;

import gmail.anastasiacoder.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.URL;

public class Browserstack {

    private static final MobileConfig BROWSERSTACK_CONFIG = ConfigFactory.create(MobileConfig.class, System.getProperties());

    private static final String user = BROWSERSTACK_CONFIG.user();
    private static final String key = BROWSERSTACK_CONFIG.key();


    public static String videoUrl(String sessionId) {

        return given()
                .auth().basic(user, key)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}