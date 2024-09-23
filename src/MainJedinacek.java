import java.io.*;

class Configurator {
    String state;
    private static Configurator singletonInstance;
    private Configurator() { }

    public synchronized static Configurator getInstance() {
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
    public static void writeToFile(String variable, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(variable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String filename) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

class StateSetter implements Runnable {
    Configurator co = Configurator.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            co.writeToFile("State " + i,"ofk.txt");
            try {
                Thread.sleep(5000);  // Simulate some delay
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
        while (true){
            System.out.println("StateGetter reads: " + co.readFromFile("ofk.txt"));
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
