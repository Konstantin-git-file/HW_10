package ru.elizarov.city;

import lombok.Data;

import java.util.Map;

@Data
public class BidirectionalCity extends City {

    public BidirectionalCity(String name) {
        super(name);
    }

    public BidirectionalCity(String name, Map<City, Integer> routes) {
        super(name, routes);
    }

    @Override
    public void addRoute(City destination, int cost) {
        if (destination == null) {
            throw new IllegalArgumentException("Город назначения не может быть null");
        }

        //  маршрут из текущего города в город назначения
        super.addRoute(destination, cost);

        //  обратный маршрут из города назначения в текущий город
        if (destination instanceof BidirectionalCity) {
            ((BidirectionalCity) destination).superAddRoute(this, cost);
        } else {
            destination.addRoute(this, cost);
        }
    }

    // метод для добавления маршрута без автоматического добавления обратного
    private void superAddRoute(City destination, int cost) {
        super.addRoute(destination, cost);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}