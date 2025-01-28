import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.floating.SerializableDouble;
import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.floating.SerializableFloat;
import net.chauhandevs.mod.easyreload.protocol.serialization.primitive.number.nondecimal.SerializableInteger;

import java.util.Scanner;

public class SerializationTest {
    public static void main(String[] args) {
        SerializableDouble f = new SerializableDouble();
        Scanner sc = new Scanner(System.in);

        while (true){
            double i = sc.nextDouble();

            System.out.println("Input:     \t" + i);
            f.set(i);
            System.out.println(f.get());
            byte[] serialized = f.serialize();
            f.deserialize(serialized);
            System.out.println("Deserialized:\t" + f.get());
            System.out.println("Correct: " + i + "==" + f.get() + ", " + (i == f.get()));
        }
    }
}
