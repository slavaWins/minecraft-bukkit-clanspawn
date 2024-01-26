package org.destplay.clanspawn.repositories;

import org.destplay.clanspawn.contracts.Clan;
import org.destplay.clanspawn.core.BaseRepository;


public final class ClanRepository extends BaseRepository<Clan> {

    @Override
    public Class<Clan[]> GetClass() {
        return Clan[].class;
    }

    @Override
    public String GetFileName() {
        return "clans-storage";
    }

    private static ClanRepository _link;

    public static ClanRepository Link(){
        if(_link==null) _link = new ClanRepository();
        return _link;
    }

}
