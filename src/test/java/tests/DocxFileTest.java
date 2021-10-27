package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readDocxFile;
import static utils.Files.readTextFromPath;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class DocxFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/1.docx";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        String actualData = readDocxFile(docxFilePath);

        assertThat(actualData, containsString(expectedData));
    }


}
