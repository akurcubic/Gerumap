package raf.dsw.gerumap.observer;

public interface IPublisher {

    void addSubscriber(ISubscriber subscriber);
    void removeSubscriber(ISubscriber subscriber);
    void notify(Object notifikacija, TipNotifikacije tipNotifikacije);

}
