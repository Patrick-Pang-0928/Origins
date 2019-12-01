package Origins;

import java.io.Serializable;

public class Monster extends Entity implements Serializable {

    public Monster(String name_Ori, String gender_Ori, int HP_Ori, int strength_Ori, int agility_Ori, int AC_Ori, String shape_Ori) {
        super(name_Ori, gender_Ori, HP_Ori, strength_Ori, agility_Ori, AC_Ori, shape_Ori);
    }
}
