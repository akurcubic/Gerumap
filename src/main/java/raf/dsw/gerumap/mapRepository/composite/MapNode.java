package raf.dsw.gerumap.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.observer.IPublisher;
import raf.dsw.gerumap.observer.ISubscriber;
import raf.dsw.gerumap.observer.TipNotifikacije;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter

public abstract class MapNode implements IPublisher {

    String name;
    private MapNode parent;
    private List<ISubscriber> subscribers;

    public MapNode(String name, MapNode parent) {
        this.parent = parent;
        this.name = name;
        subscribers = new ArrayList<>();
    }

    public MapNode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapNode mapNode = (MapNode) o;
        return Objects.equals(name, mapNode.name);
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
