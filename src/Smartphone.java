import java.util.Objects;

// Класс смартфона
public class Smartphone extends ConsumerElectronics implements Workable {

    private final String model;
    private final double displaySize;
    private int refreshRate = 0;

    // Пример статического поля
    // (проверяет есть ли широкоугольный объектив у смартфона)
    public static boolean isWideAngleLens = false;

    public Smartphone(String model,
                      double displaySize) {
        this.model = model;
        this.displaySize = displaySize;
    }

    // Пример перегрузки конструктора
    public Smartphone(String model,
                      double displaySize,
                      int refreshRate) {
        this.model = model;
        this.displaySize = displaySize;
        this.refreshRate = refreshRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        Smartphone that = (Smartphone) o;

        if (refreshRate == 0) {
            return displaySize == that.displaySize &&
                    model.equals(that.model);
        }

        return displaySize == that.displaySize &&
                refreshRate == that.refreshRate &&
                model.equals(that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, displaySize, refreshRate);
    }

    @Override
    public String toString() {
        if (refreshRate == 0) {
            return "Smartphone{" +
                    "model='" + model + '\'' +
                    ", displaySize=" + displaySize +
                    '}';
        }

        return "Smartphone{" +
                "model='" + model + '\'' +
                ", displaySize=" + displaySize +
                ", refreshRate=" + refreshRate +
                '}';
    }

    @Override
    public void use() {
        if (!isWideAngleLens) {
            System.out.println("Делаю обычное фото");
        } else {
            System.out.println("Делаю фото на широкоугольный объектив");
        }
    }

    // Реализация интерфейса
    @Override
    public void startWork() {
        System.out.println("Смартфон включается");
    }

    @Override
    public void stopWork() {
        System.out.println("Смартфон выключается");
    }
}