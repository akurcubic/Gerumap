package raf.dsw.gerumap.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.gui.swing.controller.actions.MapViewDrag;
import raf.dsw.gerumap.gui.swing.controller.actions.MapViewController;
import raf.dsw.gerumap.gui.swing.painters.ElementPainter;
import raf.dsw.gerumap.gui.swing.painters.PojamPainter;
import raf.dsw.gerumap.gui.swing.painters.VezaPainter;
import raf.dsw.gerumap.mapRepository.implementation.element.Pojam;
import raf.dsw.gerumap.mapRepository.implementation.element.Veza;
import raf.dsw.gerumap.mapRepository.implementation.mindMap.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.element.Element;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.observer.TipNotifikacije;
import raf.dsw.gerumap.state.State;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter

public class MapView extends JPanel implements ISubscriber {

    private String name;
    private MindMap mindMap;
    private Element element;
    private List<ElementPainter> painters;
    private MapViewController mapViewController;
    private MapViewDrag mapViewDrag;
    private List<ElementPainter> selektovaniElementi = new ArrayList<>();


    private int dragStartX, dragStartY;
    private double scaleX = 1;
    private double scaleY = 1;
    private double translateX = 0;
    private double translateY = 0;
    private AffineTransform at = new AffineTransform();

    public MapView(String name,MindMap mindMap){

        this.name = name;
        this.mindMap = mindMap;
        this.painters = new ArrayList<>();
        mapViewController = new MapViewController(this);
        this.addMouseListener(mapViewController);
        mapViewDrag = new MapViewDrag(this);
        this.addMouseMotionListener(mapViewDrag);
        setFocusable(true);

    }

    public void setupTransformation(){
        at.setToIdentity();
        //at.translate(translateX,translateY);
        at.scale(scaleX,scaleY);
        repaint();
    }

    public String imeMape(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }


    @Override
    public void update(Object notifikacija, TipNotifikacije tipNotifikacije) {

        if(tipNotifikacije == TipNotifikacije.DODAT_NOVI_ELEMENT_U_MAPU){
            if(notifikacija instanceof Pojam){
                Pojam pojam = (Pojam) notifikacija;
                ElementPainter elementPainter = new PojamPainter(pojam);
                this.getPainters().add(elementPainter);
            }
            else if(notifikacija instanceof Veza){
                Veza veza = (Veza) notifikacija;
                ElementPainter vezaPainter = new VezaPainter(veza);
                this.getPainters().add(vezaPainter);
            }
        }
        else if(tipNotifikacije == TipNotifikacije.IZBRISAN_ELEMENT_IZ_MAPE){

            if(notifikacija instanceof Element) {
                Element element1 = (Element) notifikacija;
                Iterator<ElementPainter> iterator = this.painters.iterator();
                while (iterator.hasNext()) {
                    ElementPainter elementPainter = iterator.next();
                    if (elementPainter.getElement().getName().equals(element1.getName())) {
                        iterator.remove();
                    }
                }
            }

        }
        else if (tipNotifikacije == TipNotifikacije.PROMENA_KOORDINATA){

        }
        else if(tipNotifikacije == TipNotifikacije.PROMENA_BOJE_ELEMENTA){

        }
        else if(tipNotifikacije == TipNotifikacije.PROMENA_ELEMENTA){

        }
        else if(tipNotifikacije == TipNotifikacije.PROMENA_VEZE_SPEC) {

        }
        repaint();
    }

    public void setMapView(MindMap mindMap){

        this.mindMap = mindMap;
        if(!mindMap.getSubscribers().isEmpty()){
            mindMap.getSubscribers().clear();
        }
        mindMap.getSubscribers().add(this);
    }

    public void postaviElement(Element element){

        this.element = element;
        if(element != null){
            if(element.getSubscribers().isEmpty()){
                element.getSubscribers().clear();
            }
            element.addSubscriber(this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setTransform(at);

        for(ElementPainter elementPainter : this.painters){
            elementPainter.draw(g);
        }

    }
    public void saveImage(File file){
        BufferedImage bi = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.createGraphics();
        this.paint(g);
        g.dispose();
        try{
            ImageIO.write(bi,"png",file);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
