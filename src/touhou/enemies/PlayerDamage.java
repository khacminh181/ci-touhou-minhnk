package touhou.enemies;

import bases.GameObject;
import bases.physics.BoxCollieder;
import touhou.players.Player;

public class PlayerDamage {
        public void run (Enemy owner) {
            BoxCollieder boxCollieder = owner.getBoxCollider();
            Player player = GameObject.collideWith(boxCollieder, Player.class);
            if (player != null) {
                player.getHit();
            }
        }
}
