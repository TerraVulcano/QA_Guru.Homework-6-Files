package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class PdfFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "./src/test/resources/1.pdf";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));

    }
}
