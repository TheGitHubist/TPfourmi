import java.util.Random;

public class Chasseresse extends Fourmi {
    private final int numChasse = new Random().nextInt(0, 999999999) + 1;
    Chasseresse(int age, int force) {
        super(age, force, "chasseresse");
    }

    @Override
    protected void communication() {
        System.out.println("La fourmi chasseresse numéro " + numChasse + " parle...");
    }

    @Override
    protected double deplacement(String environnement) {
        return getForce();
    }

    public int getNumChasse() {
        return numChasse;
    }

    @Override
    public String toString() {
        System.out.print("chasseresse ");
        String res = super.toString();
        System.out.println(" " + numChasse);
        return res;
    }
    @Override
    public void action(Fourmilliere fourmilliere) throws ExceptionNourriture {
        if (fourmilliere.getNourriture() > 10*fourmilliere.getSalles()) {
            throw new ExceptionNourriture(this);
        }
        fourmilliere.addNourriture(getForce());
        System.out.println("La chasseresse numero " + numChasse + " a rapporte " + getForce() + " nourriture");
    }
}
