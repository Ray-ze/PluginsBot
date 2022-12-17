package me.Ze.Util;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class BotConfigManager {
    public static Map<String, Object> data;
    public static void loadConfig() throws IOException {
        InputStream inputStream = new FileInputStream("src/main/resources/bot.yml");
        Yaml yaml = new Yaml();
        data = yaml.load(inputStream);
        inputStream.close();
    }
    public static String getStringValue(String key){
        return data.get(key).toString();
    }
    public static Activity getActivity(){
        Map<String, Object> activityData = (Map<String, Object>) data.get("activity");
        String activityText = activityData.get("text").toString();
        return switch (activityData.get("type").toString()) {
            case "watching" -> Activity.watching(activityText);
            case "listening" -> Activity.listening(activityText);
            default -> Activity.playing(activityText);
        };
    }
    public static OnlineStatus getStatus(){
        return switch(data.get("status").toString()){
            case "idle" -> OnlineStatus.IDLE;
            case "dnd" -> OnlineStatus.DO_NOT_DISTURB;
            case "invisible" -> OnlineStatus.INVISIBLE;
            default -> OnlineStatus.ONLINE;
        };
    }
}
