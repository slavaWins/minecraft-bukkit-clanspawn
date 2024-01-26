package org.destplay.clanspawn;

import org.bukkit.configuration.file.YamlConfiguration;
import org.destplay.clanspawn.helpers.VaultHelper;

import java.io.File;
import java.io.IOException;

public class ConfigHelper {

    private static File file;
    private static YamlConfiguration yamlConfiguration;

    public static void DefYmlConfi() {
        yamlConfiguration.set("debug", true);
        yamlConfiguration.set("valute", VaultHelper.GetDefualtValute());
        yamlConfiguration.set("valute-name", " золота");

    }

    public static boolean IsDebug(){
        return yamlConfiguration.getBoolean("debug", true);
    }

    public static void Save(){
        try {
            yamlConfiguration.save(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static YamlConfiguration GetConfig(){
        return yamlConfiguration;
    }

    public static void Init(File dataFoolder) {
        if (!dataFoolder.exists()) dataFoolder.mkdirs();


        file = new File(dataFoolder, "settings.yml");
        yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        if (!file.exists()) {
            try {
                file.createNewFile();
                DefYmlConfi();
                yamlConfiguration.save(file);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
