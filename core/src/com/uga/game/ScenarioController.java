package com.uga.game;

public class ScenarioController {
    public static void checkScenario(Scenario scenario, Scenario scenario2){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(GameScreen.height);
        } else if (scenario2.getLimit() == -2){
            scenario.setLimit(GameScreen.height - 2);
        }
    }
}
