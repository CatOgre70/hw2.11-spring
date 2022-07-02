package sky.pro.hw2_11spring.service;

import sky.pro.hw2_11spring.database.Item;

import java.util.ArrayList;

public interface BasketService {

    ArrayList<Item> add(int... id);
    ArrayList<Item> get();

}
