package raf.dsw.gerumap.messageGenerator;

import lombok.Getter;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    @Getter
    @Setter

    private String poruka;
    private String tipPoruke;

    public Message(String poruka, String tipPoruke) {
        this.poruka = poruka;
        this.tipPoruke = tipPoruke;
    }

    public String getTipPoruke() {
        return tipPoruke;
    }

    public String getPoruka(){
        return "["+ ZonedDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"]"+"["+poruka+"]";
    }
}
