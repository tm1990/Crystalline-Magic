package CrystallineMagic.Event;

import CrystallineApi.Spells.SpellUtils;
import CrystallineApi.Events.EventSpellCast;
import CrystallineMagic.Utils.MagicInfoStorage;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SpellCastEvent {

    @SubscribeEvent
    public void Event(EventSpellCast event){
        if(!event.player.worldObj.isRemote)
        if(MagicInfoStorage.get(event.player) != null){
            if(MagicInfoStorage.get(event.player).HasMagic()){
                MagicInfoStorage data = MagicInfoStorage.get(event.player);

                int g = (int) SpellUtils.GetSpellCost(event.stack);
                int h = (data.GetPlayerLevel() / 3);

                if(h <= 0)
                    h = 1;

                int Xp = (g / 20) / h;

                if(Xp <= 0)
                    Xp = 1;

                data.IncreasePlayerXp(Xp);

            }

        }

    }
}
