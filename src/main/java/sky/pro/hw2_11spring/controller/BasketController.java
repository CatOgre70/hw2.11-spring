package sky.pro.hw2_11spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.hw2_11spring.database.Item;
import sky.pro.hw2_11spring.service.BasketService;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping("/add")
    ArrayList<Item> addToBasket(@RequestParam("item") int... id){
        return basketService.add(id);
    }

    @RequestMapping("/get")
    ArrayList<Item> getBasket(){
        return basketService.get();
    }

}
