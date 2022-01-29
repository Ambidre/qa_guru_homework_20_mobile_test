package gmail.anastasiacoder.helpers;

import static io.restassured.RestAssured.given;

import gmail.anastasiacoder.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

public class Browserstack {
    public static String videoUrl(String sessionId) {

        BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
        String username = browserstackConfig.username();
        String accessKey = browserstackConfig.accessKey();
        String videoUrl = browserstackConfig.videoUrl();

        return given()
                .auth().basic(username, accessKey)
                .when()
                .get(videoUrl + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}