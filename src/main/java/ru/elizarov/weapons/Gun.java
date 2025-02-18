package ru.elizarov.weapons;

public class Gun extends Weapon {

    private final int maxBullets;

    public Gun(int maxBullets) {
        super(0); // по умолчанию пистолет разряжен
        if (maxBullets <= 0) {
            throw new IllegalArgumentException("Максимальное количество патронов должно быть положительным.");
        }
        this.maxBullets = maxBullets;
    }

    @Override
    public void shoot() {
        if (ammo() > 0) {
            System.out.println("Бах!");
            getAmmo(); // Используем один патрон
        } else {
            System.out.println("Клац!");
        }
    }

    public int reload(int bulletsToAdd) {
        if (bulletsToAdd < 0) {
            throw new IllegalArgumentException("Количество патронов не может быть отрицательным.");
        }
        int totalBullets = ammo() + bulletsToAdd;
        if (totalBullets > maxBullets) {
            int excess = totalBullets - maxBullets;
            load(maxBullets); // Загружаем максимальное количество патронов
            return excess; // Возвращаем лишние патроны
        } else {
            load(totalBullets); // Загружаем все патроны
            return 0; // Лишних патронов нет
        }
    }

    public int unload() {
        int remainingBullets = ammo();
        load(0); // Разряжаем пистолет
        return remainingBullets;
    }

    public boolean isLoaded() {
        return ammo() > 0;
    }
}