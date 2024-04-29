package raf.dsw.gerumap.core;

import raf.dsw.gerumap.observer.ISubscriber;

public interface ErrorLogger extends ISubscriber {

    void log();
}
