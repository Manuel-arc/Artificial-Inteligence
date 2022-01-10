public class Individuo {

    private Gene[] cromossoma;

    public Individuo(){
        cromossoma = new Gene[64];
    }

    public Gene[] getCromossoma(){
        return cromossoma;
    }
}
