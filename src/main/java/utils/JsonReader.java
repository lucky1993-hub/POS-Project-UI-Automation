package utils;

import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    private JSONObject jsonObject;

    public JsonReader(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(filePath).toURI())));
            jsonObject = new JSONObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLocator(String pageName, String elementName) {
        return jsonObject.getJSONObject(pageName).getString(elementName);
    }
}
