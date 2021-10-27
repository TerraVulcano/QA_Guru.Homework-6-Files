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

public class XlsFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void XlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/1.xls";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void XlsCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/1.xls";
        String expectedData = "So as I pray, Unlimited Blade Works.";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(7).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));
    }
}
