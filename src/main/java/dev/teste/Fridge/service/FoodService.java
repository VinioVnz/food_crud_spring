package dev.teste.Fridge.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import dev.teste.Fridge.model.Food;
import dev.teste.Fridge.repository.FoodRepository;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //listar
    public List<Food> listar(){
        return foodRepository.findAll();
    }
    //criar
    public Food criar(Food food){
        return foodRepository.save(food);
    }
    //deletar
    public void deletar(Long id){
        foodRepository.deleteById(id);
    }

    //update
    public Food atualizar(Long id, Food food){
        var foundedFood = foodRepository.findById(id);
        if(foundedFood.isPresent()){
            Food existingFood = foundedFood.get();
            existingFood.setName(food.getName());
            existingFood.setQuantity(food.getQuantity());
            existingFood.setExpirationDate(food.getExpirationDate());

            return foodRepository.save(existingFood);
        }

        throw new RuntimeException("Comida de id: "+id+ " não encontrada");
    }
    
}
