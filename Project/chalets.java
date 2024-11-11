package Project;

import java.util.Scanner;

public class chalets extends Main {
    private boolean swimmingPool;
    private boolean pets;

    public chalets() {
        super();
        swimmingPool = false;
        pets = false;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public void setSwimmingPool(boolean swimmingPool) {
        this.swimmingPool = swimmingPool;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public chalets(boolean swimmingPool, boolean pets) {
        this.swimmingPool = swimmingPool;
        this.pets = pets;
    }
    
}
