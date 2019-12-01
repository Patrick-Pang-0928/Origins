package Origins;

public class Golem extends Monster {
    public static String Golem_name = "魔像";
    public static String Golem_gender;
    public static int Golem_HP;
    public static int Golem_strength;
    public static int Golem_agility;
    public static int Golem_AC = 17;
    public static String Golem_shape = "大型";

    {
        Golem_HP = random_generate(9, 8, shape2HP(getShape()));
        Golem_strength = 14;
        Golem_agility = 8;

        int gender_Num = random_generate(1, 2, 0);
        if (gender_Num == 1)
            Golem_gender = "Male";
        else Golem_gender = "Female";
    }

    public Golem() {
        super(Golem_name, Golem_gender, Golem_HP, Golem_strength, Golem_agility, Golem_AC, Golem_shape);
    }

    public void Entity_Info(){
        System.out.println("族群:  魔像 Golem");
        System.out.println("性别: 雄/雌");
        System.out.println("生命: 133（17d10+" + shape2HP(getShape()) + "）");
        System.out.println("力量: 22（+6）");
        System.out.println("敏捷: 9（-1）");
        System.out.println("防御强度: 偏高");
        System.out.println("体型: " + getShape());
        return;
    }
}
