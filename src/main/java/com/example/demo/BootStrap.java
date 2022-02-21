package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.ItemType;
import com.example.demo.entity.enums.Ranks;
import com.example.demo.entity.enums.Rarity;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BootStrap {

    @Bean
    CommandLineRunner initDatabase(PlayerRepository playerRepository) {
        Player player = new Player();
        player.setName("FirstPlayer");

        Guild guild = new Guild();
        guild.setLocation("Ukraine");
        guild.setName("GuildTeam1");
        guild.setRanks(Ranks.JUNIOR);
        player.setGuild(guild);

        List<Gear> gearList = new ArrayList<>();

        Gear gear = new Gear();
        Item item1 = new Item();
        Item item2 = new Item();

        item1.setType(ItemType.TORSO);
        item1.setRarity(Rarity.COMMON);
        item1.setGear(gear);
        item2.setType(ItemType.HEAD);
        item2.setRarity(Rarity.LEGENDARY);
        item2.setGear(gear);

        gear.setItems(List.of(item1, item2));
        gearList.add(gear);

        gear.setPlayer(player);
        player.setGear(gearList);

        Stats stats = Stats.builder()
                .strength((byte) 10)
                .dexterity((byte) 12)
                .wisdom((byte) 18)
                .intelligence((byte) 92)
                .charisma((byte) 12)
                .build();
        player.setStats(stats);

        return args -> {
            if (playerRepository.count() == 0) {
                System.out.println("Preloading " + playerRepository.save(player));
            }
        };
    }
}
