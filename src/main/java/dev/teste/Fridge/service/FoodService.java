package dev.teste.Fridge.service;

import java.util.List;

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

    
}
