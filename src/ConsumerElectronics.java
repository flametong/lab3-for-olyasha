// Класс бытовой электроники
public abstract class ConsumerElectronics extends Electronics {

    public abstract void use();

    ConsumerElectronics() {
        System.out.println("---Бытовая электроника создана---");
    }

    @Override
    void emitWaves() {
        System.out.println("Бытовая электроника излучает волны");
    }
}