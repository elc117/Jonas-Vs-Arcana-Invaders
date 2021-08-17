package com.uga.game;

public class ScenarioController {
    public static void checkScenario(JonasVsArcanaInvaders game, Scenario scenario, Scenario scenario2){
        if(scenario.getLimit() == 0){
            scenario2.setLimit(game.getHeight());
        } else if (scenario2.getLimit() == -2){
            scenario.setLimit(game.getHeight() - 2);
        }
    }
}
