package org.destplay.clanspawn.core;

import com.google.gson.Gson;
import org.destplay.clanspawn.ConfigHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import org.json.simple;

public class BaseRepository<T extends IModelRepository> {

    private File file;
    private List<T> myList = new ArrayList<>();


    public T FindByName(String name) {
        for (T clan : myList) {

            System.out.println("----- [BaseRepository] FindByName in " + clan.GetName());

            if (clan.GetName().equals(name)) {
                System.out.println("----- [BaseRepository] EQ!");
                return clan;
            }
        }
        return null;
    }


    public boolean Save(List<T> list) {
        myList = list;

        Gson gson = new Gson();
        System.out.println(file.getAbsolutePath());
        try {
            file.getParentFile().mkdir();

            file.createNewFile();
            Writer writer = new FileWriter(file, false);
            gson.toJson(myList, writer);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public List<T> Get() {
        return myList;
    }

    public Class<T[]> GetClass() {
        return null;
    }

    public void Load() throws IOException {

        Gson gson = new Gson();

        if (file.exists()) {
            Reader reader = new FileReader(file);
            T[] n = gson.fromJson(reader, GetClass());
            myList = new ArrayList<>(Arrays.asList(n));
        }
    }


    public String GetFileName() {
        return "item-storage";
    }

    public void Init(File dataFoolder) {

        if (!dataFoolder.exists()) dataFoolder.mkdirs();



        file = new File(dataFoolder, GetFileName() + ".json");

        if (ConfigHelper.IsDebug()) {
            System.out.println("----- [RENT TABLE] Init.");
        }


        try {
            Load();
        } catch (IOException e) {

            System.out.println("----- [RENT TABLE] Ошибка загрузки rents-data.json возможно файл повережден");
            e.printStackTrace();
        }


    }
}
