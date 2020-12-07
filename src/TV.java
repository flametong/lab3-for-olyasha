import java.io.Serializable;
import java.util.Objects;

// Класс телевизора (сериализуемый)
public class TV extends ConsumerElectronics implements Serializable, Workable {

    private final String model;
    private final double displaySize;
    private final String resolution;

    public TV(String model,
              double displaySize,
              String resolution) {
        this.model = model;
        this.displaySize = displaySize;
        this.resolution = resolution;
    }

    public String getModel() {
        return model;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TV)) return false;
        TV tv = (TV) o;
        return getDisplaySize() == tv.getDisplaySize() &&
                getModel().equals(tv.getModel()) &&
                getResolution().equals(tv.getResolution());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getDisplaySize(), getResolution());
    }

    @Override
    public String toString() {
        return "TV{" +
                "model='" + model + '\'' +
                ", displaySize=" + displaySize +
                ", resolution='" + resolution + '\'' +
                '}';
    }

    @Override
    public void use() {
        System.out.println("Смотрю сериал на телевизоре");
    }

    // Реализация интерфейса
    @Override
    public void startWork() {
        System.out.println("Включаю телевизор");
    }

    @Override
    public void stopWork() {
        System.out.println("Выключаю телевизор");
    }
}