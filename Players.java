import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Players implements Serializable {
    private static HashMap<String, Integer> people = new HashMap<String, Integer>();
    private final static String fileName = "players.ser";

    public static Players load () {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Players p = (Players) ois.readObject();
            ois.close();
            fis.close();
            return p;
        } catch(Exception e) { // IOException, ClassNotFoundException
          return new Players();
        }
    }

    public void setInfo (String playerName, int age) {
        people.put(playerName, age);
        try {
            FileOutputStream fileout = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(this);
            out.close();
            fileout.close();
            System.out.println("serialization successful and saved in serialize.txt");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        String players = "";
        for (HashMap.Entry<String, Integer> person :people.entrySet()){
            players += ("name: " + person.getKey() +" age: " + person.getValue() + "\n");
        }
        return players;
    }
}
