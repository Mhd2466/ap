package ap.excercises.ex4;

public class E3_4 {
    public class HallwayLightControl {
        private boolean firstSwitchUp;
        private boolean secondSwitchUp;
    
        public HallwayLightControl() { 
            
            firstSwitchUp = false;
            secondSwitchUp = false;
        }
 
        public int getFirstSwitchState() {
            return firstSwitchUp ? 1 : 0;
        }
    
        public int getSecondSwitchState() {
            return secondSwitchUp ? 1 : 0;
        }
    
        public int getLampState() {
            
            return (firstSwitchUp ^ secondSwitchUp) ? 1 : 0;
        }
    
        public void toggleFirstSwitch() {
            firstSwitchUp = !firstSwitchUp;
        }
    
        public void toggleSecondSwitch() {
            secondSwitchUp = !secondSwitchUp;
        }
    }
    
}
