import org.apache.log4j.Logger;

import java.util.*;

public class MainClass {
    private final static Logger LOGGER =Logger.getLogger(MainClass.class);

    private int id;
    private String name;
    private int age;
    private Sex sex;
    private static Map<Integer, MainClass> allUsers = new HashMap<>();
    ;
    private static int countId = 0;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }
    public MainClass(String name, int age, Sex sex) {


        this.name = name;
        this.age = age;
        this.sex = sex;

        if (!hasUser()){
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }
    }
    private boolean hasUser(){
        for (MainClass user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainClass mainClass = (MainClass) o;
        return age == mainClass.age &&
                Objects.equals(name, mainClass.name) &&
                sex == mainClass.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public static List<MainClass> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static List<MainClass> getAllUsers(Sex sex){
        List<MainClass> listAllUsers = new ArrayList<>();
        for (MainClass user : allUsers.values()){
            if (user.sex == sex){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(Sex sex){
        return getAllUsers(sex).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (MainClass user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Sex sex){
        int countAge = 0;
        for (MainClass user : getAllUsers(sex)){
            countAge += user.age;
        }
        return countAge;
    }
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Sex sex){
        return getAllAgeUsers(sex) / getHowManyUsers(sex);
    }

    public static void main(String[] args) {
        new MainClass("Евгений", 35, Sex.MALE);
        new MainClass("Марина", 34, Sex.FEMALE);
        new MainClass("Алина", 7, Sex.FEMALE);


        System.out.println("Все пользователи:");
        MainClass.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        MainClass.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        MainClass.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("       всех пользователей: " + MainClass.getHowManyUsers());
        System.out.println("  всех пользователей MALE: " + MainClass.getHowManyUsers(Sex.MALE));
        System.out.println("всех пользователей FEMALE: " + MainClass.getHowManyUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       общий возраст всех пользователей: " + MainClass.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + MainClass.getAllAgeUsers(Sex.MALE));
        System.out.println("общий возраст всех пользователей FEMALE: " + MainClass.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + MainClass.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + MainClass.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("средний возраст всех пользователей FEMALE: " + MainClass.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
        LOGGER.info("main method");
    }
}
