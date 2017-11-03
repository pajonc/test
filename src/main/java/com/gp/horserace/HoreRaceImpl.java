package com.gp.horserace;

import com.gp.horserace.model.Horse;

import java.util.*;

/**
 * Created on 10/25/2017.
 */
public class HoreRaceImpl implements HorseRace {



    @Override
    public List<Horse> run(List<Horse> horses) {
        List<Horse> raceResult = new ArrayList<>();
        Random random = new Random();
        int maximumPower = 0;
        for (Horse horse : horses) {
            maximumPower = maximumPower + horse.getPower();
        }

        int wonValue = random.nextInt(maximumPower);

        int startRange=0,endRange =0;

        Horse wonHorse =null;
        for (Horse horse: horses) {
            if(startRange==0 && endRange==0) {
                endRange = horse.getPower() + startRange;
            } else {
                startRange = endRange+startRange;
                endRange=endRange+horse.getPower();
            }
            if(startRange<=wonValue&&wonValue<=endRange){
                wonHorse = horse;
            }
        }

        raceResult.add(wonHorse);
        for (Horse horse: horses) {
            if(!horse.equals(wonHorse)) raceResult.add(horse);

        }

//        Collections.sort(raceResult, (a,b)-> );
        return raceResult;
    }



//    @Override
//    public List<Horse> run(List<Horse> horses) {
//        List<Horse> raceResult = new ArrayList<>();
//
//
//        Random random = new Random();
//        for (Horse horse : horses) {
//            int newPower = random.nextInt(10) * horse.getPower();
//
//            raceResult.add(new Horse(horse.getName(),newPower));
//        }
//        Collections.sort(raceResult, Comparator.comparing(Horse::getPower).reversed());
//        return raceResult;
//    }
}
