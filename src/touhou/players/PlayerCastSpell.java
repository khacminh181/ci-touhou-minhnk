package touhou.players;

import bases.GameObject;
import bases.Vector2D;
import touhou.Inputs.InputManager;

public class PlayerCastSpell {

    boolean spellDisabled = false;
    final int COOL_DOWN_TIME = 10;
    int coolDownCount;


    public void run (Player owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (InputManager.instance.xPressed) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position);



            spellDisabled = true;
        }
    }
}
