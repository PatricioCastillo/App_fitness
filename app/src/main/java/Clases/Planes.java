package Clases;

public class Planes {

    // Declaración
    private int xtreme;
    private int mindfullness;


    // Constructor
    public Planes()
    {
        xtreme = 12000;
        mindfullness = 24000;
    }

    // Accesadores.
    public int getXtreme()
    {
        return xtreme;
    }

    public int getMindfullness()
    {
        return mindfullness;
    }

    //  Mutadores
    public void setXtreme(int xtreme)
    {
        this.xtreme = xtreme;
    }

}
