package me.Ze.Bot.Buttons;

import me.Ze.Util.BotConfigManager;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.util.ArrayList;
import java.util.Collection;

public class ButtonsGenerate {
    public static Collection<ItemComponent> generateButtons(){
         Collection<ItemComponent> buttons = new ArrayList<>();
         for(int i = 0; i < BotConfigManager.data.size(); i++){
             buttons.add(
                    Button.primary("%s".formatted(i), "d")
            );
        }
         return buttons;
    }
}
