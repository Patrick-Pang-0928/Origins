package Origins;

public class Elementals extends Monster {
    public static String Elementals_name = "元素";
    public static String Elementals_gender = null;
    public static int Elementals_HP;
    public static int Elementals_strength;
    public static int Elementals_agility;
    public static int Elementals_AC = 17;
    public static String Elementals_shape = "大型";

    {
        Elementals_HP = random_generate(9, 8, shape2HP(getShape()));
        Elementals_strength = 20;
        Elementals_agility = 8;
    }

    public Elementals() {
        super(Elementals_name, Elementals_gender, Elementals_HP, Elementals_strength, Elementals_agility, Elementals_AC, Elementals_shape);
    }

    public void Entity_Info(){
        System.out.println("族群:  元素 Elementals");
        System.out.println("性别: 无性别");
        System.out.println("生命: 106（12d10+" + shape2HP(getShape()) + "）");
        System.out.println("力量: 20（+5）");
        System.out.println("敏捷: 8（-2）");
        System.out.println("防御强度: 偏高");
        System.out.println("体型: " + getShape());
        return;
    }
}
