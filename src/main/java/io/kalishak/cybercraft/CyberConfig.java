package io.kalishak.cybercraft;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CyberConfig {
    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;
    public static final ModConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    public static class Client {
        public final ModConfigSpec.ConfigValue<String> overlayKey;

        public Client(ModConfigSpec.Builder builder) {
            builder.push("gui");
            overlayKey = builder.define("Overlay Key", "M");
            builder.pop();
        }
    }

    public static class Server {
        public final ModConfigSpec.BooleanValue spawnCyberZombies;
        public final ModConfigSpec.BooleanValue legacySurgeryChamber;

        public Server(ModConfigSpec.Builder builder) {
            builder.push("General");
            this.spawnCyberZombies = builder
                    .translation("config.cybercraft.server.general.spawn_cyber_zombies")
                    .define("Spawn Cyber Zombies", true);
            this.legacySurgeryChamber = builder
                    .translation("config.cybercraft.server.general.legacy_surgery_chamber")
                    .define("Legacy Surgery Chamber", false);
            builder.pop();
        }
    }

    static {
        var CLIENT_PAIR = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = CLIENT_PAIR.getRight();
        CLIENT = CLIENT_PAIR.getLeft();

        var SERVER_PAIR = new ModConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = SERVER_PAIR.getRight();
        SERVER = SERVER_PAIR.getLeft();
    }
}
