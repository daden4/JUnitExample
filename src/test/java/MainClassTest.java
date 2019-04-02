import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainClassTest {
    private MainClass MainClass;
    private MainClass MainClass1;
    private MainClass MainClass2;
    @Before
    public void setUp() throws Exception {
        MainClass = new MainClass("Евгений", 35, Sex.MALE);
        MainClass1 = new MainClass("Марина", 34, Sex.FEMALE);
        MainClass2 = new MainClass("Алина", 7, Sex.FEMALE);
    }


    @Test
    public void getAllMainClasss() {
        //создаем список expected и заполняем его данными нашего метода
        List<MainClass> expected = MainClass.getAllUsers();

        //создаем список actual в него помещаем данные для сравнения
        //то что мы предпологиаем метод должен вернуть
        List<MainClass> actual = new ArrayList<>();
        actual.add(MainClass);
        actual.add(MainClass1);
        actual.add(MainClass2);

        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllMainClasss_NO_NULL() {
        //добавим проверку на null
        List<MainClass> expected = MainClass.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllMainClasss_MALE() {

        List<MainClass> expected = MainClass.getAllUsers(Sex.MALE);

        List<MainClass> actual = new ArrayList<>();
        actual.add(MainClass);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllMainClasss_MALE_NO_NULL() {
        //добавим проверку на null
        List<MainClass> expected = MainClass.getAllUsers(Sex.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllMainClasss_FEMALE() {

        List<MainClass> expected = MainClass.getAllUsers(Sex.FEMALE);

        List<MainClass> actual = new ArrayList<>();
        actual.add(MainClass1);
        actual.add(MainClass2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllMainClasss_FEMALE_NO_NULL() {
        //добавим проверку на null
        List<MainClass> expected = MainClass.getAllUsers(Sex.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyMainClasss() {

        int expected = MainClass.getHowManyUsers();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyMainClasss_MALE() {

        int expected = MainClass.getHowManyUsers(Sex.MALE);

        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyMainClasss_FEMALE() {

        int expected = MainClass.getHowManyUsers(Sex.FEMALE);

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeMainClasss() {


        int expected = MainClass.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeMainClasss_MALE() {


        int expected = MainClass.getAllAgeUsers(Sex.MALE);

        int actual = 35;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeMainClasss_FEMALE() {


        int expected = MainClass.getAllAgeUsers(Sex.FEMALE);

        int actual = 34 + 7;

        Assert.assertEquals(expected, actual);
    }
}