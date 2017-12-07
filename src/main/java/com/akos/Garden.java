package com.akos;

import com.akos.plants.Plant;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Огород. Можно сажать растения, собирать урожай, так же здесь растения растут
 */
public class Garden {

    private List<Plant> plants = new LinkedList<>();

    private Conditions conditions;

    public Garden(Conditions conditions) {
        this.conditions = conditions;
    }

    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    /**
     * Посадить растение в огород
     *
     * @param p растение
     */
    public void plant(Plant p) {
        p.setConditions(conditions);
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
    public void printPlants(){
        System.out.println("Garden: ");
        for (Plant p:plants) {
            System.out.println(p);
        }
    }

}
