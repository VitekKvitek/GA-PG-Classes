class Configurator {
    String state;
    private static Configurator singletonInstance;
    private Configurator() { }

    public static Configurator getInstance() {
        if (null == singletonInstance) {
            singletonInstance = new Configurator();
        }
        return singletonInstance;
    }
    public void setState(String newState){
        state = newState;
    }
    public String getState(){
        return state;
    }
}

class StateSetter implements Runnable {
    Configurator co = Configurator.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            co.setState("State " + i);
            try {
                Thread.sleep(1000);  // Simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class StateGetter implements Runnable {
    Configurator co = Configurator.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("StateGetter reads: " + co.getState());
            try {
                Thread.sleep(1000);  // Simulate some delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MainJedinacek {
    public static void main(String[] args) {
        StateSetter SS = new StateSetter();
        StateGetter SG = new StateGetter();

        Thread setterThread = new Thread(SS);
        Thread getterThread = new Thread(SG);

        setterThread.start();
        getterThread.start();
    }
}
