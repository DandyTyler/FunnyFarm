package com.akos;

import com.akos.exceptions.IllegalConditionException;
import com.akos.store.Order;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FarmTest {
    private Farm farm;

    //Potato cost = 5, Carrot cost =2
    @Before
    public void setUp() {
        this.farm = new Farm(20);
        farm.setGardenContions(new Conditions(65, 27, 400, Seasons.SUMMER));
    }

    @Test
    public void test_bonuses() {
        assertThat(farm.getBonuses(), is(20));
    }

    @Test
    public void test_bonuses_after_purchase() {
        farm.buyAndPlant(new Order().add("Potato", 2).add("Carrot", 4));
        assertThat(farm.getBonuses(), is(2));
    }

    @Test
    public void test_purchase_and_sell() {
        farm.buyAndPlant(new Order().add("Potato", 2).add("Carrot", 4));
        farm.doHarvest();
        farm.doHarvest();
        farm.sellHarvest("Potato", 10);
        farm.sellHarvest("Carrot", 5);
        assertThat(farm.getBonuses(), is(42));
    }

    @Test(expected = IllegalConditionException.class)
    public void test_wrong_season() {
        farm.setGardenContions(new Conditions(65, 27, 400, Seasons.WINTER));
        farm.buyAndPlant(new Order().add("Potato", 1));
        farm.doHarvest();
    }

    @Test(expected = IllegalConditionException.class)
    public void test_wrong_temperature() {
        farm.setGardenContions(new Conditions(65, 10, 400, Seasons.SUMMER));
        farm.buyAndPlant(new Order().add("Carrot", 1));
        farm.doHarvest();
    }
}
