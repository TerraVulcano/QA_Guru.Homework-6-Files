package tests;

import com.codeborne.selenide.Configuration;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static utils.Files.readTextFromPath;

public class ZipFileTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void ZipSimpleTest() throws IOException, ZipException {
        String zipFilePath = "./src/test/resources/1.zip";
        String unzipFolderPath = "./src/test/resources/unzip";
        String unzipTxtFilePath = "./src/test/resources/unzip/1.txt";
        String zipPassword = "Archer";
        String expectedData = "So as I pray, Unlimited Blade Works.";


        ZipFile zipFile = new ZipFile(zipFilePath);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(zipPassword);
        }
        zipFile.extractAll(unzipFolderPath);


        String actualData = readTextFromPath(unzipTxtFilePath);
        assertThat(actualData, containsString(expectedData));
    }

}
