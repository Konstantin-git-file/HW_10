package ru.elizarov.weapons;

public class AutomaticGun extends Gun {
    private final int fireRate;

    // без параметров (скорострельность 30, вместимость 30)
    public AutomaticGun() {
        this(30, 30); // Вызов основного конструктора
    }

    // с указанием максимального числа патронов (скорострельность равна половине обоймы)
    public AutomaticGun(int maxBullets) {
        this(maxBullets, maxBullets / 2); // Скорострельность равна половине обоймы
    }

    // конструктор с указанием максимального количества патронов и скорострельности
    public AutomaticGun(int maxBullets, int fireRate) {
        super(maxBullets);
        if (fireRate <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной.");
        }
        this.fireRate = fireRate;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < fireRate; i++) {
            if (ammo() > 0) {
                System.out.println("Бах!");
                getAmmo(); // Используем один патрон
            } else {
                System.out.println("Клац!");
                break; // Прекращаем стрельбу, если патроны закончились
            }
        }
    }

    // для стрельбы в течение N секунд
    public void shootForSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным.");
        }
        for (int i = 0; i < seconds; i++) {
            shoot(); // Стреляем в течение каждой секунды
        }
    }

    public int getFireRate() {
        return fireRate;
    }
}