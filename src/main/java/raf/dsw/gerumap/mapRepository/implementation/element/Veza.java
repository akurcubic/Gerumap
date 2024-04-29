package raf.dsw.gerumap.mapRepository.implementation.element;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

@Getter
@Setter

public class Veza extends Element{

    private Pojam pojamOd;
    private Pojam pojamDo;

    private int xPocetak;
    private int xKraj;
    private int yPocetak;
    private int yKraj;

    public Veza(MapNode parent, String name, Pojam pojamOd, Pojam pojamDo) {
        super(parent, name);
        this.pojamOd = pojamOd;
        this.pojamDo = pojamDo;
    }

    public Veza(MapNode parent, String name) {
        super(parent, name);
    }

    public Pojam getPojamOd() {
        return pojamOd;
    }

    public void setPojamOd(Pojam pojamOd) {
        this.pojamOd = pojamOd;
    }

    public Pojam getPojamDo() {
        return pojamDo;
    }

    public void setPojamDo(Pojam pojamDo) {
        this.pojamDo = pojamDo;
    }

}
