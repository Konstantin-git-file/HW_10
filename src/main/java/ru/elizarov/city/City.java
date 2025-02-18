package ru.elizarov.city;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    public City(String name, Map<City, Integer> routes) {
        this.name = name;
        this.routes = routes != null ? new HashMap<>(routes) : new HashMap<>();
    }

    public void addRoute(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.put(destination, cost); // Добавляем или обновляем маршрут
    }

    public void removeRoute(City destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }
        routes.remove(destination); // Удаляем маршрут
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":\n");
        for (Map.Entry<City, Integer> entry : routes.entrySet()) {
            sb.append("  -> ").append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;

        // у городов дб одинаковые маршруты, но без учета стоимости
        Set<City> thisDestinations = new HashSet<>(routes.keySet());
        Set<City> otherDestinations = new HashSet<>(city.routes.keySet());
        return Objects.equals(thisDestinations, otherDestinations);
    }

    @Override
    public int hashCode() {
        // только список городов без стоимости маршрута
        return Objects.hash(new HashSet<>(routes.keySet()));
    }
}