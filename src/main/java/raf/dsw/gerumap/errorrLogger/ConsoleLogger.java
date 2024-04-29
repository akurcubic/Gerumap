package raf.dsw.gerumap.errorrLogger;

import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.messageGenerator.Message;
import raf.dsw.gerumap.observer.TipNotifikacije;

public class ConsoleLogger implements ErrorLogger{

    private Message message;

    @Override
    public void log() {

        ///[ERROR][12.11.2022. 22:56] ProjectExplorer ne može biti obrisan.

        String poruka = message.getPoruka();
        String tipPoruke = message.getTipPoruke();
        System.out.println("[" + tipPoruke + "] " + poruka);
    }

    @Override
    public void update(Object notifikacija, TipNotifikacije tipNotifikacije) {

        if(notifikacija instanceof Message && tipNotifikacije == TipNotifikacije.MESSAGE_GENERATOR){
            Message m = (Message)notifikacija;
            this.message = m;
            log();
        }
    }
}
