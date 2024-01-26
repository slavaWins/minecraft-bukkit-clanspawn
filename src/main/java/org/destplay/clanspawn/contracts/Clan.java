package org.destplay.clanspawn.contracts;

import org.destplay.clanspawn.core.IModelRepository;

public class Clan implements IModelRepository {

    public Integer price;
    public String name;

    public double  x;
    public double  y;
    public double  z;
    public String world;

    @Override
    public String GetName() {
        return name;
    }

    /**
     * Актуальна ли аренда сейчас?
     * @return
     */
    public boolean IsLocked(){
        return false;
    }
}
