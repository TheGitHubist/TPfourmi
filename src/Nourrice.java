import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Nourrice extends Fourmi {
    Nourrice(int age, int force) {
        super(age, force, "nourrice");
    }

    @Override
    protected void communication() {
        System.out.println("La fourmi nourrice parle...");
    }

    @Override
    protected double deplacement(String environnement) {
        if (environnement.equals("herbe")) {
            return 0.5;
        }
        return 1.0;
    }

    @Override
    public String toString() {
        System.out.print("nourrice ");
        String res = super.toString();
        System.out.println(" ");
        return res;
    }
    @Override
    public void action(Fourmilliere fourmilliere) throws InterruptedException {
        System.out.println("La fourmi nourrice s'occupe d'un oeuf...");
        TimeUnit.SECONDS.sleep(1);
        int naissance = new Random().nextInt(1, 4);
        if (fourmilliere.getOeufs() >= 1) {
            switch (naissance) {
                case 1:
                    fourmilliere.addFourmi(new Nourrice(1, new Random().nextInt(1, 11)));
                    fourmilliere.delOeufs(1);
                    System.out.println("L'oeuf a eclos et est devenu une nouvelle nourrice !");
                    break;
                case 2:
                    fourmilliere.addFourmi(new Chasseresse(1, new Random().nextInt(1, 11)));
                    fourmilliere.delOeufs(1);
                    System.out.println("L'oeuf a eclos et est devenu une nouvelle chasseresse !");
                    break;
                case 3:
                    fourmilliere.addFourmi(new Ouvriere(1, new Random().nextInt(1, 11)));
                    fourmilliere.delOeufs(1);
                    System.out.println("L'oeuf a eclos et est devenu une nouvelle ouvriere !");
                    break;
                default:
                    action(fourmilliere);
                    System.out.println("Il n'y a plus d'oeufs");
                    break;
            }
        }
    }
}
