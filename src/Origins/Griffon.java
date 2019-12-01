package Origins;

public class Griffon extends Monster {
    public static String Griffon_name = "狮鹫";
    public static String Griffon_gender;
    public static int Griffon_HP;
    public static int Griffon_strength;
    public static int Griffon_agility;
    public static int Griffon_AC = 13;
    public static String Griffon_shape = "大型";

    {
        Griffon_HP = random_generate(9, 8, shape2HP(getShape()));
        Griffon_strength = 14;
        Griffon_agility = 8;

        int gender_Num = random_generate(1, 2, 0);
        if (gender_Num == 1)
            Griffon_gender = "Male";
        else Griffon_gender = "Female";
    }

    public Griffon() {
        super(Griffon_name, Griffon_gender, Griffon_HP, Griffon_strength, Griffon_agility, Griffon_AC, Griffon_shape);
    }

    public void Entity_Info(){
        System.out.println("族群:  狮鹫 Griffon");
        System.out.println("性别: 雄/雌");
        System.out.println("生命: 78（7d10+" + shape2HP(getShape()) + "）");
        System.out.println("力量: 18（+4）");
        System.out.println("敏捷: 15（+2）");
        System.out.println("防御强度: 中等");
        System.out.println("体型: " + getShape());
        return;
    }
}
