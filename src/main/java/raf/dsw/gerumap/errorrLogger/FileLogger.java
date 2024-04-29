package raf.dsw.gerumap.errorrLogger;

import raf.dsw.gerumap.core.ErrorLogger;
import raf.dsw.gerumap.messageGenerator.Message;
import raf.dsw.gerumap.observer.TipNotifikacije;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements ErrorLogger{


    private Message message;
    @Override
    public void log() {
        String poruka = message.getPoruka();
        String tipPoruke = message.getTipPoruke();
        String putanjaDoFajla = "src/main/resources/log.txt";
        String tekstZaUpis = "[" + tipPoruke + "] " + poruka;

        try {
            FileWriter writer = new FileWriter(putanjaDoFajla, true);
            writer.write(tekstZaUpis + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Došlo je do greške prilikom upisa u fajl: " + e.getMessage());
        }
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
