package Origins;

import java.io.Serializable;

public class Hero extends Entity implements Serializable {
    private int password = 0;

    public Hero(String name_Ori, String gender_Ori, int HP_Ori, int strength_Ori, int agility_Ori, int AC_Ori, String shape_Ori, int password) {
        super(name_Ori, gender_Ori, HP_Ori, strength_Ori, agility_Ori, AC_Ori, shape_Ori);
        setPassword(password);
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password_Ori) {
        password = password_Ori;
    }

    public void reincarnate(){
        HP = HP_max;
    }

}
