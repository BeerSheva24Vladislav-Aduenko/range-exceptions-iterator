package telran.range;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BrokenFloorTest {

    private int getMinimalBrokenFloor(BallBrokenFloor bbf) {
        int minFloor = 0;
        int maxFloor = Integer.MAX_VALUE;

        while (minFloor <= maxFloor) {
           int midFloor = (maxFloor + minFloor) / 2;
            try { 
                bbf.checkFloor(midFloor);
                minFloor = midFloor  + 1;
            } catch (Exception e){   
                maxFloor = midFloor  -1;
            }
        }
        return minFloor;
    }


    @Test
    void minimalBrokenFloorTest() {
        int [] floors = {200, 17, 1001, 2000};
        for(int i = 0; i < floors.length; i++) {
            BallBrokenFloor bbf = new BallBrokenFloor(floors[i]);
            assertEquals(bbf.getMinBrokenFloor(), getMinimalBrokenFloor(bbf));
        }
    }
}
