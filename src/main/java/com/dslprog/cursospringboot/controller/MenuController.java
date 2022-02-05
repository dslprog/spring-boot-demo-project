package com.dslprog.cursospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping(value = "/menu", produces = "application/json")
    public String getMenu(){
        Resource resource = resourceLoader.getResource("classpath:menu.json");
        String resourceData = ResourceReader.asString(resource);
        return resourceData;
    }

    public static class ResourceReader {

        public static String asString(Resource resource) {
            try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
                return FileCopyUtils.copyToString(reader);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }

        // more utility methods
    }
}
