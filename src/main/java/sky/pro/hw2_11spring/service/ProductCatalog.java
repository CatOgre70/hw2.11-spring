package sky.pro.hw2_11spring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import sky.pro.hw2_11spring.database.Item;
import sky.pro.hw2_11spring.exceptions.ItemNotFoundException;
import sky.pro.hw2_11spring.exceptions.ProductCatalogIsEmptyException;

import java.util.HashMap;
import java.util.Map;


@Service
@Scope("singleton")
public class ProductCatalog {

    Map<Integer, Item> pCatalog;

    public ProductCatalog() {
        pCatalog = new HashMap<>();

        pCatalog.put(1, new Item(1, "Подушка", "Простая подушка из шерсти банты"));
        pCatalog.put(2, new Item(2, "Одеяло", "Одеяло из шкуры богликов"));
        pCatalog.put(3, new Item(3, "Световой меч", "Поврежден. Когда-то им владел джедай"));
        pCatalog.put(4, new Item(4, "Бластер", "Спортивная модель"));
        pCatalog.put(5, new Item(5, "Рука робота серии C3", "Красная"));
        pCatalog.put(6, new Item(6, "Модуль прицеливания", "Похоже, что от Икс-крыла"));
        pCatalog.put(7, new Item(7, "Кристалл", "Красный, светится изнутри"));
        pCatalog.put(8, new Item(8, "Зуб крайт-дракона", "Очень большой и дорогой"));
        pCatalog.put(9, new Item(9, "Коммуникатор", "Стандартная модель"));
        pCatalog.put(10, new Item(10, "Дроид серии R2", "Немного поломатый"));
        pCatalog.put(11, new Item(11, "Гипердвигатель", "Для крейсеров класса \"Нубиан\""));

    }

    public Item add(Item item){
        if(item == null)
            throw new NullPointerException("Illegal argument in productCatalog.add() method!");
        if(pCatalog.containsKey(item.getId())) return pCatalog.get(item.getId());
        return pCatalog.put(item.getId(), item);
    }

    public Item add(int id, String name, String description){
        if(pCatalog.containsKey(id)) return pCatalog.get(id);
        Item item = new Item(id, name, description);
        return pCatalog.put(id, item);
    }

    public Item find(int id){
        if(!pCatalog.containsKey(id))
            throw new ItemNotFoundException("Item with such id is not found in the database");
        return pCatalog.get(id);
    }

    public Item remove(int id){
        if(!pCatalog.containsKey(id))
            throw new ItemNotFoundException("Item with such id is not found in the database");
        return pCatalog.remove(id);
    }

    public boolean check(int id){
        return pCatalog.containsKey(id);
    }

    public Map<Integer, Item> listAll(){
        if(pCatalog.isEmpty())
            throw new ProductCatalogIsEmptyException("Product catalog is empty!");
        return pCatalog;
    }

}
