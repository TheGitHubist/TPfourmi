import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ouvriere extends Fourmi {

    Ouvriere(int age, int force) {
        super(age, force, "ouvriere");
    }

    @Override
    protected void communication() {
        System.out.println("La fourmi ouvriere parle");
    }

    @Override
    protected double deplacement(String environnement) {
        if (environnement.equals("sable")) {
            return 2.0;
        }
        return 1.0;
    }

    @Override
    public String toString() {
        System.out.print("ouvriere ");
        String res = super.toString();
        System.out.println(" ");
        return res;
    }
    @Override
    public void action(Fourmilliere fourmilliere) throws InterruptedException {
        System.out.println("La fourmi ouvriere essaye d'agrandir la fourmiliere !");
        TimeUnit.SECONDS.sleep(1);
        int proba = (int)((0.1/getAge())*100);
        int ch = new Random().nextInt(1, 101);
        if (ch < proba) {
            fourmilliere.addSalles(1);
            System.out.println("La fourmi ouvriere a reussie a ajouter une nouvelle salle a la fourmiliere !");
        }
    }
}
