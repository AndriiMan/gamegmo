package com.example.demo;

import com.example.demo.entity.*;
import com.example.demo.entity.enums.ItemType;
import com.example.demo.entity.enums.Ranks;
import com.example.demo.entity.enums.Rarity;
import com.example.demo.repositories.GuildRepository;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class BootStrap {

    private ArrayList<Guild> guilds = new ArrayList<>();

    private final PlayerRepository playerRepository;
    private final GuildRepository guildRepository;
    private final Random rand = new Random();
    NameGenerator nameGenerator = new NameGeneratorImpl();

    private final int COUNT_OF_PLAYERS = 100;
    private final int COUNT_OF_GUILDS = 10;

    public BootStrap(PlayerRepository playerRepository, GuildRepository guildRepository) {
        this.playerRepository = playerRepository;
        this.guildRepository = guildRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            if (guildRepository.count() == 0) {
                guildRepository.saveAllAndFlush(getGuildias());
            }
            for (int j = 1; j <= COUNT_OF_PLAYERS; j++) {
                System.out.println("Preloading of " + j + " " + playerRepository.saveAndFlush(getRandomPlayer()));
            }
        };
    }

    private Player getRandomPlayer() {
        //PLAYER
        Player player = new Player();

        player.setName(getRandomName());

        //PLAYER'S GEAR
        List<Gear> gearList = new ArrayList<>();
        Gear gear = getRandomGear();
        gearList.add(gear);
        gear.setPlayer(player);
        player.setGear(gearList);

        //PLAYER'S STATS
        Stats stats = getRandomStats();
        stats.setPlayer(player);
        player.setStats(stats);

        //PLAYER'S GUILD
        player.setGuild(getRandomGuild());

        return player;
    }

    private String getRandomName() {
        int randInt;
        String name = nameGenerator.generateName();
        if (playerRepository.existsPlayerByName(name)) {
            randInt = rand.nextInt(COUNT_OF_PLAYERS);
            if (playerRepository.existsPlayerByName(name.concat(String.valueOf(randInt)))) {
                getRandomName();
            }
            return name.concat(String.valueOf(randInt));
        } else {
            return name;
        }
    }

    private Gear getRandomGear() {
        Gear gear = new Gear();
        List<Item> itemList = getRandomItems(gear);
        gear.setItems(itemList);
        return gear;
    }

    private List<Item> getRandomItems(Gear gear) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(4); i++) {
            items.add(getRandomItem(gear));
        }
        return items;
    }

    private Item getRandomItem(Gear gear) {
        Item item1 = new Item();
        item1.setType(ItemType.getRandomItemType());
        item1.setRarity(Rarity.getRandomRarity());
        item1.setGear(gear);
        return item1;
    }

    private Stats getRandomStats() {
        return Stats.builder()
                .strength((byte) rand.nextInt(100))
                .dexterity((byte) rand.nextInt(100))
                .wisdom((byte) rand.nextInt(100))
                .intelligence((byte) rand.nextInt(100))
                .charisma((byte) rand.nextInt(100))
                .build();
    }

    private Guild getRandomGuild() {
        return guildRepository.findByName(guilds.get(rand.nextInt(guilds.size())).getName());
    }

    private ArrayList<Guild> getGuildias() {
        for (int i = 0; i < COUNT_OF_GUILDS; i++) {
            Guild guild = new Guild();
            guild.setLocation("Ukraine");
            guild.setName("GuildTeam" + i);
            guild.setRanks(Ranks.getRandomRank());
            guilds.add(guild);
        }
        return guilds;
    }
}