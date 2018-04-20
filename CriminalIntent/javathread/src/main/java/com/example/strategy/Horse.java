package com.example.strategy;

/**
 * @author Caicai.
 * @date 2018/4/2.
 * @description
 */

public class Horse {
    private Strategy strategy;

//    public Horse(Strategy strategy){
//        this.strategy = strategy;
//    }
    public void factory(String strategyType){
        if ("Win".equals(strategyType)){
            strategy = new StrategyA();
        }else if ("lose".equals(strategyType)){
            strategy = new StrategyB();
        }
    }

    public void horseInterface(){
        strategy.algorithmLogic();
    }
}
