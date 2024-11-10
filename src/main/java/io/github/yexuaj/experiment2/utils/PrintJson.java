package io.github.yexuaj.experiment2.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

public class PrintJson {
    private PrintJson() {}

    // Print a JSON flag to the response
    public static void printJsonFlag(HttpServletResponse response, boolean flag) {
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("success", flag);
        printJsonObj(response, map);
    }

    // Print obj to the response
    public static void printJsonObj(HttpServletResponse response, Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(obj);
            response.getWriter().print(s);
        } catch (IOException e) {
            LoggerFactory.getLogger(PrintJson.class).error(e.getMessage());
        }
    }

}
