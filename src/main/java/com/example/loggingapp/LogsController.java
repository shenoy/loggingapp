package com.example.loggingapp;


import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LogsController {
Logger logger = LoggerFactory.getLogger(LogsController.class);
    @GetMapping(value = "/")
    public String getLogs(Model model) throws IOException {

        logger.info("[getMessage] info message");
        logger.warn("[getMessage] warn message");
        logger.error("[getMessage] error message");
        logger.debug("[getMessage] debug message");
        logger.trace("[getMessage] trace message");

        List<String> logs = Files.readAllLines(Paths.get("application.log"), StandardCharsets.UTF_8);

        model.addAttribute("logs", logs);

        return "index";

    }


}
