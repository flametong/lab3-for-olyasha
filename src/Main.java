import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Actions actions = new Actions();
        actions.showEquality();
        actions.showSomeMethods();
        actions.showPolymorphism();
        actions.showSerialization();
    }
}

// Класс демонстраций действий с сущностными классами
class Actions {

    // Делает разделительную черту для удобства
    // чтения в консоли
    private void makeDividingLine() {
        System.out.println("-----------------------------------");
    }

    public void showEquality() {
        Smartphone smartphone1 = new Smartphone("iPhone 12", 6.1);
        Smartphone smartphone2 = new Smartphone("iPhone 12", 6.1);
        Smartphone smartphone3 = new Smartphone("Samsung Galaxy S20", 6.2, 120);

        // Проверка на равенство двух экземпляров одного класса
        System.out.println("Равенство между iPhone 12 и ещё одним iPhone 12: "
                + smartphone1.equals(smartphone2));
        System.out.println("Равенство между iPhone 12 и Samsung Galaxy S20: "
                + smartphone1.equals(smartphone3));

        makeDividingLine();
    }

    public void showSomeMethods() {
        TV tv = new TV("LG WX", 65, "4K");
        tv.use();
        tv.startWork();
        tv.stopWork();

        makeDividingLine();

        // Демонстрация метода toString()
        System.out.println(tv);

        makeDividingLine();

        Smartphone smartphone = new Smartphone("iPhone 12", 6.1);

        // До изменения статического поля isWideAngleLens
        smartphone.use();

        Smartphone.isWideAngleLens = true;

        // После изменения статического поля isWideAngleLens
        smartphone.use();

        makeDividingLine();
    }

    public void showPolymorphism() {
        // Список из двух классов-наследников электроники
        List<ConsumerElectronics> electronics = Arrays.asList(
                new Smartphone("iPhone 12", 6.1),
                new TV("LG WX", 65, "4K"));

        for (ConsumerElectronics electronicsItem : electronics) {
            // Полиморфный вызов метода use через класс-родитель
            electronicsItem.use();
        }

        makeDividingLine();
    }

    public void showSerialization() {

        // Сериализация
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("electronics.dat"))) {
            TV tv = new TV("LG WX", 65, "4K");
            oos.writeObject(tv);
            System.out.println("---Сериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Десериализация
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("electronics.dat")
        )) {
            TV tv = (TV) ois.readObject();

            System.out.printf(
                    "Model: %s\nDisplay size: %f\nResolution: %s\n",
                    tv.getModel(),
                    tv.getDisplaySize(),
                    tv.getResolution());

            System.out.println("---Десериализация успешно завершена---");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}