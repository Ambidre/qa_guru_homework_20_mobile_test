package gmail.anastasiacoder.helpers;

import static io.restassured.RestAssured.given;

import gmail.anastasiacoder.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.URL;

public class Browserstack {

    public static String videoUrl(String sessionId) {

        MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class);

        String user = mobileConfig.user();
        String key = mobileConfig.key();

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