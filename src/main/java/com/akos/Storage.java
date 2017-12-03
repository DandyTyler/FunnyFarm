package com.akos;

import com.akos.plants.Plant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище. Можно помещать сюда собранный урожай или забирать его из хранилища. Для хранения данных
 * о урожае спользует мапу, т.к после сборки важно только количество урожая того или иного растения
 */
public class Storage {
    private Map<String, Integer> storage = new HashMap<>();

    /**
     * Отравить собранный урожай на склад
     * Если на складе уже есть такие растения, увеличивает их количество.
     *
     * @param p растение
     */
    public void sendToStorage(Plant p) {
        if (storage.containsKey(p.getName()))
            storage.put(p.getName(), storage.get(p.getName()) + 1);
        else storage.put(p.getName(), 1);
    }

    public void sendToStorage(List<Plant> plants) {
        for (Plant p : plants) {
            sendToStorage(p);
        }
    }

    /**
     * Забирает данное растение из хранилища
     *
     * @param plantName растение
     * @return количество растений, находившееся на складе
     */
    public int removeFromStorage(String plantName) {
        int quantity = 0;
        if (storage.containsKey(plantName)) {
            quantity = storage.get(plantName);
            storage.put(plantName, 0);
        }
        return quantity;
    }
}
