package com.gp.horserace;

import com.gp.horserace.model.Horse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created on 10/25/2017.
 */
public class HoreRaceImplTest {

    private HorseRace horseRace;

    @Before
    public void setUp() throws Exception {
        horseRace = new HoreRaceImpl();

    }

    @Test
    public void testRun10000times() throws Exception {
        //given
        List<Horse> horses = generateHorses();
        int counterForBullet= 0;
        //when
        for(int i=0;i<10000;i++){
            List<Horse> raceResult = horseRace.run(horses);
            if(raceResult.get(0).getName().equals("bullet")){
                counterForBullet++;
            };
        }
        //then
        System.out.println(counterForBullet);
        assertTrue(counterForBullet>6000);


    }

    private List<Horse> generateHorses() {
        Horse turtle = new Horse("turtle",4);
        Horse bullet = new Horse("bullet",8);
        List horses = new ArrayList(2);
        horses.add(turtle);
        horses.add(bullet);
        return horses;
    }

}