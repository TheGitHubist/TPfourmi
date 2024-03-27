public class ExceptionNourriture extends Exception {
    public ExceptionNourriture(Chasseresse chasseresse) {
        super("La fourmi chasseresse numero " + chasseresse.getNumChasse() + " a travaillé pour rien !");
    }
}
