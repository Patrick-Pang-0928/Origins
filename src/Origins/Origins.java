package Origins;

import java.io.*;
import java.util.Scanner;

public class Origins {
    private static int exit_flag = 0;
    private static int login_flag = 0;
    private static int game_flag = 0;
    private static int option_flag = 0;
    private static int PasswordChange_flag = 0;
    private static int battle_flag = 0;
    private static int newUser_flag = 0;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    private static Scanner sc = new Scanner(System.in);

    private static Hero Patrick = new Hero("Patrick", "Male", 200, 15, 10, 10, "中型", 9580);
    private static Hero Passerby = new Hero("路人甲", "Male", 200, 15, 10, 10, "中型", 0);
    private static Goblin goblin = new Goblin();
    private static Werewolf werewolf = new Werewolf();
    private static Griffon griffon = new Griffon();
    private static Golem golem = new Golem();
    private static Elementals elementals = new Elementals();


    public static void main(String[] args){
        Hero user = null;
        String read;

        System.out.println("\n欢迎进入Origins！\n");

        while (exit_flag == 0) {
            String read_name = null;
            int read_password = 0;
            //System.out.println("  注册        登录");
            System.out.println("玩家登录    游客登录    退出游戏");
            try {
                read = br.readLine();
                switch (read) {
                    //case "登录":
                    case  "玩家登录":
                        while (exit_flag != 2) {
                            System.out.println("\n请输入玩家名称");
                            try{
                                read_name = br.readLine();
                            }catch (IOException e) {
                                System.out.println("你的名字好像不对劲诶～");
                            }

                            user = heroNameCheck(read_name);
                            if (user == null){
                                System.out.println("\n该玩家无游戏记录");
                                newUser_flag = 1;
                                while (newUser_flag != 0) {
                                    System.out.println("请选择：");
                                    System.out.println("重新输入    退出游戏\n");

                                    try {
                                        read = br.readLine();
                                        switch (read) {
                                            case "重新输入":
                                                newUser_flag = 0;
                                                break;
                                            case "退出游戏":
                                                return;
                                            default:
                                                System.out.println("\n请正确输入：");
                                                continue;
                                        }
                                    } catch (IOException e) {
                                        System.out.println("你的选择好像不对劲诶～");
                                        e.printStackTrace();

                                    }
                                }
                                if (newUser_flag == 0)
                                    continue;
                            }
                            else {
                                System.out.println("请输入你的密码：");
                                int passwordCheck = 0;
                                read_password = sc.nextInt();

                                try(
                                        DataInputStream load = new DataInputStream(
                                                new FileInputStream(user.getName() + "_Password.txt"))
                                ){
                                    passwordCheck = load.readInt();
                                } catch (FileNotFoundException e) {
                                    passwordCheck = user.getPassword();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                if (read_password == passwordCheck){
                                    exit_flag = 2;
                                    login_flag = 1;
                                }
                                else {
                                    System.out.println("密码错误！");
                                    exit_flag = 0;
                                }

                            }
                        }
                        break;

                    case "游客登录":
                        user = Passerby;
                        exit_flag = 2;
                        login_flag = 1;
                        break;

                    case "退出游戏":
                        exit_flag = 1;
                        break;
                    default:
                        System.out.println("这不是正确的指令哦～\n");
                        break;
                }
            } catch (IOException e) {
                System.out.println("你的输入好像不对劲诶～");
            }

            if (exit_flag == 2)
                if(user(user, user.name) == 0)
                    exit_flag = 0;
            if (exit_flag == 1) return;
        }
    }

    public static int user(Hero user, String username){
        String read;
        String read_name = null;
        Entity user_check;

        System.out.println("\n欢迎你，" + username + "！");

        if (user.getName() == "路人甲") {
            System.out.println("新的游戏    登录界面");
        }
        else System.out.println("新的游戏    载入进度    登录界面");

        while (login_flag != 0) {

            try {
                read = br.readLine();
                switch (read) {
                    case "新的游戏":
                        user = new Hero("Patrick", "Male", 200, 15, 10, 10, "中型", 9580);
                        game_flag = 1;
                        login_flag = 0;
                        System.out.print("\n");
                        break;
                    case "载入进度":
                        System.out.print("\n");

                        try(
                                ObjectInputStream load = new ObjectInputStream(
                                        new FileInputStream(user.getName() + ".txt"))
                        ){
                            user = (Hero) load.readObject();
                        } catch (FileNotFoundException e) {
                            System.out.println("该玩家无游戏记录。");
                            System.out.println("已创建新的记录。\n");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        game_flag = 1;
                        login_flag = 0;
                        break;
                    case "登录界面":
                        System.out.print("\n");
                        option_flag = 0;
                        game_flag = 0;
                        login_flag = 0;
                        break;
                    default:
                        continue;
                }
            } catch (IOException e) {
                System.out.println("你的输入好像不对劲诶～");
                e.printStackTrace();
            }
        }

        while (game_flag != 0) {
            System.out.println("我的数据    怪物图鉴");
            System.out.println("发起攻击    其他选项\n");
            try {
                read = br.readLine();
                switch (read) {
                    case "我的数据":
                        user.getInfo();
                        entityAliveCheck(user);
                        System.out.print("\n");
                        break;

                    case "怪物图鉴":
                        System.out.println("\n请输入你想查询的角色");
                        System.out.println("哥布林 Goblin");
                        System.out.println("狼人 Werewolf");
                        System.out.println("狮鹫 Griffon");
                        System.out.println("魔像 Golem");
                        System.out.println("元素 Elementals");
                        System.out.print("\n");

                        try{
                            read_name = br.readLine();
                        }catch (IOException e) {
                            System.out.println("你的输入好像不对劲诶～");
                        }

                        user_check = monsterNameCheck(read_name);
                        if (user_check == null) {
                            System.out.println("此角色不存在\n");
                            game_flag = 1;
                            break;
                        }

                        switch (user_check.getName()) {
                            case "哥布林":
                            case "狼人":
                            case "狮鹫":
                            case "魔像":
                            case "元素":
                                user_check.Entity_Info();
                                break;
                            default:
                                break;
                        }

                        System.out.print("\n");
                        break;

                    case "发起攻击":
                        if (user.HP == 0){
                            System.out.println("你当前HP为0，无法发起攻击！");
                            System.out.println("是否需要复活你的角色？（是/否）");

                            try{
                                read = br.readLine();
                                if (read == "是"){
                                    user.reincarnate();
                                }
                            }
                            catch (IOException e){
                                System.out.println("你的输入好像不对劲诶～");
                            }

                            break;
                        }

                        System.out.println("\n你想选择谁作为攻击对象呢？");
                        try{
                            read_name = br.readLine();
                        }catch (IOException e) {
                            System.out.println("你的输入好像不对劲诶～");
                        }

                        user_check = monsterNameCheck(read_name);
                        if (user_check == null) {
                            System.out.println("此角色不存在\n");
                            game_flag = 1;
                            break;
                        }

                        battle_flag = 1;
                        while (battle_flag != 0) {
                            user.attack(user, user_check);
                            System.out.println("\n你当前HP为： " + user.getHP());
                            System.out.println(user_check.getName() + "当前HP为： " + user_check.getHP());
                            System.out.print("\n");

                            if ((user_check.getHP() != 0) && (user.getHP() != 0)) {
                                continue;
                            }
                            else battle_flag = 0;
                        }

                        if (user.getHP() != 0) {
                            System.out.println("你打败了" + user_check.getName() + "！");
                            System.out.print("\n");
                        }

                        break;

                    case "其他选项":
                        option_flag = 1;
                        if (Option(user) == 0){
                            if (game_flag != 0)
                                game_flag = 1;
                            else return game_flag;
                        }
                        break;

                    default:
                        System.out.println("\n请正确输入：");
                        continue;
                }
            } catch (IOException e) {
                System.out.println("你的输入好像不对劲诶～");
                e.printStackTrace();

            }
        }
        return game_flag;
    }

    public static int Option(Hero user){
        String read;
        int read_password;

        while (option_flag != 0) {
        System.out.println("保存进度    修改密码");
        System.out.println("登录界面    返回上层\n");
        try {
            read = br.readLine();
            switch (read) {
                case "保存进度":
                    if (user.getName() == "路人甲") {
                        System.out.println("你是游客身份，无法保存游戏！");
                        continue;
                    }

                    gameSave(user);
                    System.out.println("保存成功！");

                    continue;

                case "修改密码":
                    if (user.getName() == "路人甲") {
                        System.out.println("你是游客身份，无法修改密码！");
                        continue;
                    }

                    System.out.println("修改密码会保存进度，确定修改吗？");
                    System.out.println("是   否");
                    PasswordChange_flag = 1;

                    while (PasswordChange_flag != 0) {

                        try {
                            read = br.readLine();
                            switch (read) {
                                case "是":

                                    System.out.println("请输入旧密码：");
                                    read_password = sc.nextInt();
                                    if (read_password != user.getPassword()) {
                                        System.out.println("旧密码输入错误！\n");
                                        break;
                                    }

                                    System.out.println("请输入新密码：");
                                    read_password = sc.nextInt();
                                    System.out.println("请再次输入新密码：");
                                    if (read_password != sc.nextInt()) {
                                        System.out.println("两次新密码不一致！\n");
                                        break;
                                    }

                                    user.setPassword(read_password);
                                    gameSave(user);
                                    passwordSave(user.getName(),read_password);
                                    System.out.println("新密码设置成功！请重新登录。\n");
                                    PasswordChange_flag = 0;
                                    option_flag = 0;
                                    login_flag = 0;
                                    game_flag = 0;
                                    break;

                                case "否":
                                    System.out.print("\n");
                                    PasswordChange_flag = 0;
                                    option_flag = 0;
                                    break;
                                default:
                                    continue;
                            }
                        } catch (IOException e) {
                            System.out.println("你的输入好像不对劲诶～");
                            e.printStackTrace();
                        }
                    }
                    break;

                case "登录界面":
                    System.out.print("\n");
                    option_flag = 0;
                    game_flag = 0;
                    login_flag = 0;
                    break;

                case "返回上层":
                    option_flag = 0;
                    break;

                default:
                    System.out.println("\n请正确输入：");
                    continue;
            }
        }catch (IOException e) {
            System.out.println("你的输入好像不对劲诶～");
            e.printStackTrace();

        }
        }
        return option_flag;
    }

    public static Hero heroNameCheck(String heroName){
        Hero hero = null;
            switch (heroName) {
                case "Patrick":
                    hero = Patrick;
                    break;
                default:
                    break;
            }

        return hero;
    }

    public static Monster monsterNameCheck(String monsterName){

            switch (monsterName) {
                case "Goblin":
                case "哥布林":
                    return new Goblin();
                case "Werewolf":
                case "狼人":
                    return new Werewolf();
                case "Griffon":
                case "狮鹫":
                    return new Griffon();
                case "Golem":
                case "魔像":
                    return new Golem();
                case "Elementals":
                case "元素":
                    return new Elementals();
                default:
                    break;
            }

        return null;
    }

    public static void entityAliveCheck(Entity entity){
        if (entity.HP == 0) {
            System.out.println(entity.getName() + "已经挂了。\n");
        }
    }

    public static void gameSave(Entity user){
        File file =new File(user.getName() + ".txt");
        if(file.exists()&&file.isFile())
            file.delete();

        try(
                ObjectOutputStream save = new ObjectOutputStream(
                        new FileOutputStream(user.getName() + ".txt"))
        ){
            save.writeObject(user);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void passwordSave(String userName, int password){
        File file =new File(userName + "_Password.txt");
        if(file.exists()&&file.isFile())
            file.delete();

        try(
                DataOutputStream save = new DataOutputStream(
                        new FileOutputStream(userName + "_Password.txt"))
        ){
            save.writeInt(password);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}