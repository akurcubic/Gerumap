package raf.dsw.gerumap.mapRepository.implementation.element;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.observer.TipNotifikacije;

import java.awt.*;

@Setter
@Getter

public class Element extends MapNode {

    private int debljina = 3;
    private int colour = 0x000000;
    private String name;

    public Element(MapNode parent, String name) {
        super(name, parent);
    }

    public void noveKoordinate(Element element,int x,int y){

        if(element instanceof Pojam){
            Pojam pojam = (Pojam)element;
            pojam.setX(x);
            pojam.setY(y);
            notify(pojam, TipNotifikacije.PROMENA_KOORDINATA);
        }
    }
    public void noveKoordinateVeze(Veza veza,int xPocetak, int yPocetak, int xKraj, int yKraj){

        veza.setXPocetak(xPocetak);
        veza.setYPocetak(yPocetak);
        veza.setXKraj(xKraj);
        veza.setYKraj(yKraj);
        notify(veza, TipNotifikacije.PROMENA_VEZE_SPEC);
    }
    public void bojaZaSelektovaniElement(Element element){


        notify(element,TipNotifikacije.PROMENA_BOJE_ELEMENTA);
    }

    public void promenaElementa(String naziv, int debljina, Color color, Element element){

        if(!naziv.isEmpty()){
            this.setName(naziv);
        }
        this.setDebljina(debljina);
        if(color != null)
            this.setColour(color.getRGB());
        notify(element,TipNotifikacije.PROMENA_ELEMENTA);
    }

    @Override
    public String toString() {
        return name;
    }

    public int getDebljina() {
        return debljina;
    }

    public void setDebljina(int debljina) {
        this.debljina = debljina;
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
