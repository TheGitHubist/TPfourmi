public abstract class Fourmi {
    private int age;
    private int force;
    private final String classe;
    Fourmi(int age, int force, String classe) {
        this.age = age;
        this.force = force;
        this.classe = classe;
    }

    public int getAge() {
        return age;
    }

    public int getForce() {
        return force;
    }

    public String getClasse() {
        return classe;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setForce(int force) {
        this.force = force;
    }
    protected abstract void communication();
    protected abstract double deplacement(String environnement);

    public String toString() {
        System.out.print(age + "age " + force + " force");
        return null;
    }
    public abstract void action(Fourmilliere fourmilliere) throws InterruptedException, ExceptionNourriture;
}
