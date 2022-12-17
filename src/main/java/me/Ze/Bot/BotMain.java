package me.Ze.Bot;

import me.Ze.Bot.Commands.SendList;
import me.Ze.Util.BotConfigManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;

import java.io.IOException;

public class BotMain {
    public BotMain() throws IOException {
        BotConfigManager.loadConfig();
    }
    public void Start() throws InterruptedException {
        JDA jda = JDABuilder.createDefault(BotConfigManager.getStringValue("token").toString())
                .setActivity(BotConfigManager.getActivity())
                .setStatus(BotConfigManager.getStatus())
                .addEventListeners(new SendList())
                //.setAutoReconnect(true)
                .build().awaitReady();

        Guild guild = jda.getGuildById(BotConfigManager.getStringValue("guildID"));

        assert guild != null;
        guild.upsertCommand("send", "Sends the plugin list").queue();
    }
}
