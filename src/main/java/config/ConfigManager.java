package config;


import org.aeonbits.owner.ConfigCache;

public class ConfigManager {

    private ConfigManager(){
    }

    public static Configuration conf(){
        return ConfigCache.getOrCreate(Configuration.class);
    }
}
