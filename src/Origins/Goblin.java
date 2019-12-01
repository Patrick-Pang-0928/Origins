package Origins;

public class Goblin extends Monster {
    public static String Goblin_name = "哥布林";
    public static String Goblin_gender;
    public static int Goblin_HP;
    public static int Goblin_strength;
    public static int Goblin_agility;
    public static int Goblin_AC = 9;
    public static String Goblin_shape = "小型";

    {
        Goblin_HP = random_generate(8, 8, shape2HP(getShape()));
        Goblin_strength = 8;
        Goblin_agility = 13;

        int gender_Num = random_generate(1, 2, 0);
        if (gender_Num == 1)
            Goblin_gender = "Male";
        else Goblin_gender = "Female";
    }

    public Goblin() {
        super(Goblin_name, Goblin_gender, Goblin_HP, Goblin_strength, Goblin_agility, Goblin_AC, Goblin_shape);
    }

    public void Entity_Info(){
        System.out.println("族群:  哥布林 Goblins");
        System.out.println("性别: 雄/雌");
        System.out.println("生命: 36（8d8+" + shape2HP(getShape()) + "）");
        System.out.println("力量: 8（-1）");
        System.out.println("敏捷: 14（+2）");
        System.out.println("防御强度: 较低");
        System.out.println("体型: " + getShape());
        return;
    }
}
