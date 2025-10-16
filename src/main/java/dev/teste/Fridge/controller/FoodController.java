package dev.teste.Fridge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.teste.Fridge.model.Food;
import dev.teste.Fridge.service.FoodService;

@RestController
@RequestMapping("/food") //em caso de deploy add url antes de /food
public class FoodController {
    //injeção de dependencia
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }
    
    //GET
    @GetMapping
    public List<Food> getAll(){
        return foodService.listar();
    }
    //POST
    @PostMapping
    public Food create(@RequestBody Food food){
        return foodService.criar(food);
    }
    //DELETE

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        foodService.deletar(id);
    }
}
