package raf.dsw.gerumap.messageGenerator;

import raf.dsw.gerumap.core.MessageGenerator;
import raf.dsw.gerumap.main.Main;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.observer.TipNotifikacije;

import java.util.ArrayList;
import java.util.List;

public class MessageGeneratorImpl implements MessageGenerator, IPublisher {

    private List<ISubscriber> subscribers = new ArrayList<>();

    public MessageGeneratorImpl(){

        this.addSubscriber(Main.gui);
        this.addSubscriber(Main.errorLogger);
    }

    @Override
    public void generate(TipPoruke tipPoruke) {
        if(tipPoruke == TipPoruke.CVOR_NE_MOZE_BITI_OBRISAN){
            this.notify(new Message("Cvor ne moze da se obrise!","ERROR"),TipNotifikacije.MESSAGE_GENERATOR);
        }
        else if(tipPoruke == TipPoruke.NE_MOZETE_DODATI_CVOR){
            this.notify(new Message("Elementi se dodaju na desnom toolBaru!","ERROR"),TipNotifikacije.MESSAGE_GENERATOR);
        }
        else if(tipPoruke == TipPoruke.IME_NE_MOZE_DA_BUDE_PRAZNO){
            this.notify(new Message("Naziv ne moze da bude prazan!","WARRNING"),TipNotifikacije.MESSAGE_GENERATOR);
        }
        else if(tipPoruke == TipPoruke.MORATE_SELEKTOVATI_ITEM){
            this.notify(new Message("Morate selektovati item u projectExplorer-u","NOTIFIKACION"),TipNotifikacije.MESSAGE_GENERATOR);
        }

    }

    @Override
    public void addSubscriber(ISubscriber subscriber) {

        if(subscriber == null)
            return;
        if(this.subscribers.contains(subscriber))
            return;
        this.subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(ISubscriber subscriber) {

        if(subscriber == null)
            return;
        if(!this.subscribers.contains(subscriber))
            return;
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notify(Object notifikacija, TipNotifikacije tipNotifikacije) {

        for(ISubscriber subscriber : this.subscribers){
            subscriber.update(notifikacija, tipNotifikacije);
        }
    }
}
