package sky.pro.hw2_11spring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import sky.pro.hw2_11spring.database.Item;

import java.util.ArrayList;

@Service
@SessionScope
public class BasketServiceImpl implements BasketService {

    private final ArrayList<Item> basket;

    private final ProductCatalog pCatalog;

    public BasketServiceImpl(ProductCatalog pCatalog) {
        this.basket = new ArrayList<>();
        this.pCatalog = pCatalog;
    }

    @Override
    public ArrayList<Item> add(int... id) {
        for (int j : id) {
            if (pCatalog.check(j))
                basket.add(pCatalog.find(j));
        }
        return basket;
    }

    @Override
    public ArrayList<Item> get() {
        return basket;
    }
}
