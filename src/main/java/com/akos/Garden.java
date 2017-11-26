package com.akos;

import com.akos.plants.Plant;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Огород. Можно сажать растения, собирать урожай, так же здесь растения растут
 */
public class Garden {

    private List<Plant> plants = new LinkedList<>();

    /**
     * Посадить растение в огород
     *
     * @param p растение
     */
    public void plant(Plant p) {
        plants.add(p);
    }

    /**
     * Собрать урожай растений, готовых к сборке. После каждой сборки урожая растения растут
     *
     * @return List собранных растений
     */
    public List<Plant> harvest() {
        List<Plant> h = new LinkedList<>();
        Iterator<Plant> iter = plants.iterator();
        while (iter.hasNext()) {
            Plant p = iter.next();
            if (p.isReady()) {
                h.add(p);
                iter.remove();
            }
        }
        doGrow();
        return h;
    }

    /**
     * Все растения в огороде растут
     */
    private void doGrow() {
        for (Plant p : plants) {
            p.grow();
        }
    }

}
