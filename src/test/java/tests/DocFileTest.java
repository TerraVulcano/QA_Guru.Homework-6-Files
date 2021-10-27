package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class DocFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/1.doc";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        String actualData = readTextFromPath(docFilePath);

        assertThat(actualData, containsString(expectedData));
    }
}
