package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;

public class XlsxFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void XlsxTest() throws IOException {
        String xlsxFilePath = "./src/test/resources/1.xlsx";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        String actualData = readXlsxFromPath(xlsxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
