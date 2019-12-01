package Origins;

import java.io.Serializable;

public class Entity implements Serializable, Attack {
    public String name;    //名字
    private String gender;  //性别
    public int HP, HP_max;  //生命力
    private int strength;    //力量
    private int agility;    //敏捷
    public int AC;  //防御强度
    public String shape;   //体型

    public Entity(String name_Ori, String gender_Ori, int HP_Ori, int strength_Ori, int agility_Ori, int AC_Ori, String shape_Ori){
        name = name_Ori;
        gender = gender_Ori;
        HP_max = HP_Ori;
        strength = strength_Ori;
        agility = agility_Ori;
        AC = AC_Ori;
        shape = shape_Ori;
        HP = HP_max;
    }


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getHP() {
        return HP;
    }

    public int getStrength(){
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getAC() {
        return AC;
    }

    public String getShape() {
        return shape;
    }

    public String getPronoun(){
        if (getGender() == "Male")
            return "他";
        else if (getGender() == "Female")
            return "她";
        else return "它";
    }

    public void getInfo(){
        System.out.println("名字: " + name);
        System.out.println("性别: " + gender);
        System.out.println("生命: " + HP);
        System.out.println("力量: " + strength);
        System.out.println("敏捷: " + agility);
        System.out.println("防御强度: " + AC);
        System.out.println("体型: " + shape);
    }

    public void Entity_Info(){
        return;
    }



    public static int mapping(int argument) {
        int map_num;

        map_num = (argument-10)/2;

        return map_num;
    }

    public static int mapping(String shape) {
        int map_num = 0;
        switch (shape) {
            case "超巨型":
                map_num = -8;
                break;
            case "巨型":
                map_num = -4;
                break;
            case "大型":
                map_num = -2;
                break;
            case "较大型":
                map_num = -1;
                break;
            case "中型":
                map_num = 0;
                break;
            case "较小型":
                map_num = +1;
                break;
            case "小型":
                map_num = +2;
                break;
            case "微型":
                map_num = +4;
                break;
            case "超微型":
                map_num = +8;
                break;
            default:
                break;
        }

        return map_num;
    }

    public static int shape2HP(String shape) {
        int HP_revise = 0;

        switch (shape) {
            case "超巨型":
                HP_revise = 80;
                break;
            case "巨型":
                HP_revise = 60;
                break;
            case "大型":
                HP_revise = 40;
                break;
            case "较大型":
                HP_revise = 30;
                break;
            case "中型":
                HP_revise = 20;
                break;
            case "较小型":
                HP_revise = 10;
                break;
            default:
                break;
        }

        return HP_revise;
    }

    public static int random_generate(int frequency, int range, int revise) {
        int generate_Num = 0;

        for (int i=0; i<frequency; i++){
            generate_Num = generate_Num + (int)(Math.random()*(range-1+1)+range);
        }
        generate_Num = generate_Num + revise;

        return generate_Num;
    }



    private Entity firstAttacker = null;
    private Entity secondAttacker = null;

    @Override
    public void attack(Entity declare, Entity hostile) {
        System.out.print("\n");
        attack_priority(declare, hostile);

        damage(firstAttacker, secondAttacker);
        dead(declare);

        if (secondAttacker.getHP() != 0) {
            damage(secondAttacker, firstAttacker);
            dead(hostile);
        }

        return;
    }

    @Override
    public void attack_priority(Entity declare, Entity hostile) {
        int declare_No = 0;
        int hostile_No = 0;

        declare_No = random_generate(1, 20, 0) + (declare.getAgility()-10)/2;
        hostile_No = random_generate(1, 20, 0) + (hostile.getAgility()-10)/2;

        if (declare_No >= hostile_No) {
            firstAttacker = declare;
            secondAttacker = hostile;
        }
        else {
            firstAttacker = hostile;
            secondAttacker = declare;
        }
        return;
    }

    @Override
    public void damage(Entity declare, Entity hostile) {
        int damageToHostile;

        if (!miss(declare, hostile)) {
            damageToHostile = declare.getStrength();
            System.out.println(declare.getName() + " 对 " + hostile.getName() + " 造成了 " + damageToHostile + " 点伤害");
            hostile.HP = hostile.HP - damageToHostile;
        }
        else {
            System.out.println(hostile.getName() + " 闪避了 " + declare.getName() + " 的攻击!");
        }

        return;
    }

    @Override
    public boolean miss(Entity declare, Entity hostile) {
        int attack_judge = 0;
        int defend_judge = 0;

        attack_judge = random_generate(1, 20, 0) + mapping(declare.getStrength()) + mapping(declare.getShape());
        defend_judge = hostile.getAC() + mapping(hostile.getAgility()) + mapping(hostile.getShape());

        if (defend_judge >= attack_judge) {
            return true;
        }
        else return false;
    }

    @Override
    public boolean dead(Entity entity) {
        if (entity.HP < 0){
            entity.HP = 0;
        }

        if (entity.HP == 0) {
            System.out.println(entity.getName() + "已经挂了。");
            return true;
        }
        else return false;
    }

}
