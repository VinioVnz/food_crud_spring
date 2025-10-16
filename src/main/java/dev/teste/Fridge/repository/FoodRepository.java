package dev.teste.Fridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.teste.Fridge.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{

}
