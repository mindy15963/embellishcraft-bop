package tv.mapper.embellishcraftbop.util;

import java.util.List;
import java.util.Map;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TagViewer
{
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent e)
    {
        if(!Screen.hasControlDown())
            return;
        List<ITextComponent> tooltips = e.getToolTip();
        Item item = e.getItemStack().getItem();
        Map<ResourceLocation, Tag<Item>> tagmap = ItemTags.getCollection().getTagMap();
        for(Map.Entry<ResourceLocation, Tag<Item>> entry : tagmap.entrySet())
        {
            if(item.isIn(entry.getValue()))
            {
                tooltips.add(new StringTextComponent("Tag: " + entry.getKey().toString()).applyTextStyle(TextFormatting.DARK_GRAY));
            }
        }
    }

}
