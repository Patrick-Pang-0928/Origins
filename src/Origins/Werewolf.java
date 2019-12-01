package Origins;

public class Werewolf extends Monster {
    public static String Werewolf_name = "狼人";
    public static String Werewolf_gender;
    public static int Werewolf_HP;
    public static int Werewolf_strength;
    public static int Werewolf_agility;
    public static int Werewolf_AC = 13;
    public static String Werewolf_shape = "中型";

    {
        Werewolf_HP = random_generate(9, 8, shape2HP(getShape()));
        Werewolf_strength = 14;
        Werewolf_agility = 8;

        int gender_Num = random_generate(1, 2, 0);
        if (gender_Num == 1)
            Werewolf_gender = "Male";
        else Werewolf_gender = "Female";
    }

    public Werewolf() {
        super(Werewolf_name, Werewolf_gender, Werewolf_HP, Werewolf_strength, Werewolf_agility, Werewolf_AC, Werewolf_shape);
    }

    public void Entity_Info(){
        System.out.println("族群:  狼人 Werewolves");
        System.out.println("性别: 雄/雌");
        System.out.println("生命: 60（9d8+" + shape2HP(getShape()) + "）");
        System.out.println("力量: 14（+2）");
        System.out.println("敏捷: 11（+0）");
        System.out.println("防御强度: 中等");
        System.out.println("体型: " + getShape());
        return;
    }
}
