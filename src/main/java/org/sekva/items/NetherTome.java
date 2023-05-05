package org.sekva.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class NetherTome extends ItemStack {
    
    public NetherTome() {
        super(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) getItemMeta();
        
        bookMeta.spigot().addPage(pagina1());

        bookMeta.setTitle("Tomo do Nether");
        bookMeta.setAuthor("Sekva");
        bookMeta.setDisplayName("Tomo do Nether");

        setItemMeta(bookMeta);
    }

    public static boolean isNetherTome(ItemStack item) {

        NetherTome instanceTome = new NetherTome();
        BookMeta thisMeta = (BookMeta) instanceTome.getItemMeta();

        try {

            BookMeta otherMeta = (BookMeta) item.getItemMeta();

            if(otherMeta.getPageCount() != thisMeta.getPageCount()) return false;
            if(!otherMeta.getTitle().equals(thisMeta.getTitle())) return false;
            if(!otherMeta.getAuthor().equals(thisMeta.getAuthor())) return false;

            for(int i = 1; i <= thisMeta.getPageCount(); i++ ) {
                if(!otherMeta.getPage(i).equals(thisMeta.getPage(i))) return false;
            }
            
            return true;
            
        } catch(Exception _e) {
            // _e.printStackTrace();
            return false;
        }
        
    }

    private static BaseComponent[] pagina1() {
        BaseComponent[] page = new ComponentBuilder("Click me")
            .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://spigotmc.org"))
            .create();
        return page;
    }
   
}
