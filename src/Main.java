import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ExceptionNourriture, InterruptedException {
        Fourmilliere fourmilliere = new Fourmilliere();
        Nourrice nourrice1 = new Nourrice(1, new Random().nextInt(1, 11));
        Chasseresse chasseresse1 = new Chasseresse(1, new Random().nextInt(1, 11));
        Ouvriere ouvriere = new Ouvriere(1, new Random().nextInt(1, 11));
        fourmilliere.addFourmi(nourrice1);
        fourmilliere.addFourmi(chasseresse1);
        fourmilliere.addFourmi(ouvriere);
        while (!fourmilliere.getFourmisPresentes().isEmpty()) {
            String res = fourmilliere.toString();
            TimeUnit.SECONDS.sleep(1);
            fourmilliere.action();
            System.out.println("\n");
            if (res != null) {
                return;
            }
            for (Fourmi fourmi : fourmilliere.getFourmisPresentes()) {
                fourmi.setAge(fourmi.getAge() + 1);
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.println("\n");
        }
    }
}