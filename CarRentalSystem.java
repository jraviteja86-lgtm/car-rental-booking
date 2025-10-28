package com.carrental;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public CarRentalSystem() {
        // Seed with sample cars
        addCar(new Car(1, "Maruti Swift", 5, 1500));
        addCar(new Car(2, "Hyundai i20", 5, 1800));
        addCar(new Car(3, "Toyota Innova", 7, 3500));
        addCar(new Car(4, "Honda City", 5, 2000));
        addCar(new Car(5, "Mahindra XUV", 7, 3200));
    }

    public void addCar(Car c) { cars.add(c); }
    public List<Car> getCars() { return cars; }
    public List<Booking> getBookings() { return bookings; }

    public Car findCarById(int id) {
        for (Car c : cars) if (c.getId() == id) return c;
        return null;
    }

    public Booking createBooking(String customerName, int carId, LocalDate from, LocalDate to) {
        Car car = findCarById(carId);
        if (car == null) throw new IllegalArgumentException("Invalid car id");
        Booking b = new Booking(customerName, car, from, to);
        bookings.add(b);
        return b;
    }

    public boolean cancelBooking(int bookingId) {
        return bookings.removeIf(b -> b.getId() == bookingId);
    }
}
