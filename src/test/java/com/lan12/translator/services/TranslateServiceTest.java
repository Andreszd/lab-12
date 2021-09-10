package com.lan12.translator.services;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.hibernate.result.Output;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslateServiceTest {

    @Autowired
    private TranslateService translateService;

    @Test
    void givenFileTextWhenReverseItsTextAndInsertInNewFileThenSuccess() throws IOException {
        String pathFileReaded = "src/main/resources/static/original.txt";
        String pathOutputFile = "src/test/resources/static/estrofasEnOrdenInverso.txt";
        File outputFile = new File(pathOutputFile);

        assertTrue(outputFile.createNewFile());

        String contentFile = translateService.getInverseTextInverseFile(pathFileReaded);

        OutputStream out = new FileOutputStream(pathOutputFile);

        StreamUtils.copy(contentFile, StandardCharsets.UTF_8, out);

        assertEquals(contentFile, translateService.getTextContent(pathOutputFile));
    }

    @Test
    public void givenLyricsOfMusicCounterAmountStanzas() throws IOException {
        String pathFileReaded = "src/main/resources/static/original.txt";
        String pathOutputFile = "src/test/resources/static/statistics.txt";
        File outputFile = new File(pathOutputFile);

        assertTrue(outputFile.createNewFile());

        int amountStanzas = translateService.counterAmountLineSpaces(pathFileReaded);

        OutputStream out = new FileOutputStream(pathOutputFile);

        StreamUtils.copy("Amount Stanzas: "+amountStanzas, StandardCharsets.UTF_8, out);

        assertEquals(16, amountStanzas);
    }
}