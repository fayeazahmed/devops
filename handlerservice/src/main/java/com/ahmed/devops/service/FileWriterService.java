package com.ahmed.devops.service;

import com.ahmed.devops.config.FileWriterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class FileWriterService {
    private final Logger logger = LoggerFactory.getLogger(FileWriterService.class);
    @Value("${directoryPath}")
    private String directoryPath;

    public void writeToFile(String requestData) {
        String filePath = directoryPath + File.separator + System.currentTimeMillis() + FileWriterConfig.DEFAULT_FILE_EXTENSION;
        File file = new File(filePath);
        try {
            if(!file.exists() && !file.createNewFile()) return;
        } catch (IOException e) {
            logger.error("Error while creating file for request data: " + e.getMessage());
            return;
        }

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(requestData);
            logger.info("File written successfully: " + filePath);
        } catch (IOException e) {
            logger.error("Error while writing request data: " + e.getMessage());
        }
    }
}
