import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Fourmilliere {
    private int oeufs;
    private int nourriture;
    private int salles;
    private ArrayList<Fourmi> fourmisPresentes = new ArrayList<>();
    Fourmilliere() {
        oeufs = new Random().nextInt(10, 21);
        nourriture = new Random().nextInt(15, 21);
        salles = new Random().nextInt(3, 8);
    }

    public ArrayList<Fourmi> getFourmisPresentes() {
        return fourmisPresentes;
    }

    public int getNourriture() {
        return nourriture;
    }

    public int getOeufs() {
        return oeufs;
    }

    public int getSalles() {
        return salles;
    }
    public void addFourmi(Fourmi fourmi) {
        fourmisPresentes.add(fourmi);
    }
    public void addOeufs(int add) {
        oeufs += add;
    }
    public void delOeufs(int del) {
        oeufs -= del;
    }
    public void addSalles(int add) {
        salles += add;
    }
    public void addNourriture(int add) {
        nourriture += add;
    }

    @Override
    public String toString() {
        System.out.println("Nourriture " + nourriture);
        System.out.println("Oeufs " + oeufs);
        System.out.println("Salles " + salles + "\n");
        String res = "";
        for (Fourmi fourmi : getFourmisPresentes()) {
            res = fourmi.toString();
        }
        return res;
    }
    public void action() throws ExceptionNourriture, InterruptedException {
        nourriture -= fourmisPresentes.size();
        ArrayList<Fourmi> fourmiActuels = new ArrayList<>(fourmisPresentes);
        System.out.println("\n");
        oeufs += new Random().nextInt(0, 6);
        for (Fourmi fourmi : fourmiActuels) {
            fourmi.action(this);
            if (fourmi.getAge() > 3) {
                System.out.println("une fourmi " + fourmi.getClasse() + " viens de mourir.");
                fourmisPresentes.remove(fourmi);
            }
        }
    }
}
