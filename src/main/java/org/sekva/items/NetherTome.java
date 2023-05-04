package org.sekva.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class NetherTome {



    private static BaseComponent[] pagina1() {
        BaseComponent[] page = new ComponentBuilder("Click me")
            .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://spigotmc.org"))
            .create();
        return page;
    }


    
    public static ItemStack getTome() {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();

        bookMeta.spigot().addPage(pagina1());

        bookMeta.setTitle("Tomo do Nether");
        bookMeta.setAuthor("Sekva");
        bookMeta.setDisplayName("Tomo do Nether");

        book.setItemMeta(bookMeta);
        return book;       
    }
    

    
}
