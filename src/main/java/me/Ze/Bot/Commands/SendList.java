package me.Ze.Bot.Commands;

import me.Ze.Bot.Buttons.ButtonsGenerate;
import me.Ze.Util.BotConfigManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;

import java.awt.*;


public class SendList extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if(event.getName().equals("send")){
            MessageChannelUnion channel = event.getChannel();
            EmbedBuilder builder = new EmbedBuilder()
                    .addField("Plugins List",BotConfigManager.getStringValue("embedtext"),true)
                    .setColor(Color.BLUE);
            channel.sendMessageEmbeds(builder.build()).addActionRow(
                    ButtonsGenerate.generateButtons()
            ).queue();

            event.reply("done").setEphemeral(true).queue();
        }
    }
}
