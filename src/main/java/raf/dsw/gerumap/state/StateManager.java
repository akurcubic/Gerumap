package raf.dsw.gerumap.state;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.gerumap.state.concrete.*;

@Getter
@Setter

public class StateManager {

    private AddPojamState addPojamState;
    private AddVezaState addVezaState;
    private DeleteElementState deleteElementState;
    private MoveElementState moveElementState;
    private SettingsState settingsState;
    private ZoomInState zoomState;
    private ZoomOutState zoomOutState;
    private SelectionState selectionState;
    private State currState;

    public StateManager(){

        addPojamState = new AddPojamState();
        addVezaState = new AddVezaState();
        deleteElementState = new DeleteElementState();
        moveElementState = new MoveElementState();
        settingsState = new SettingsState();
        zoomState = new ZoomInState();
        zoomOutState = new ZoomOutState();
        selectionState = new SelectionState();
        currState = addPojamState;
    }

    public void setAddPojamState(){

        this.currState = addPojamState;
    }
    public void setAddVezaState(){

        this.currState = addVezaState;
    }
    public void setDeleteElementState(){

        this.currState = deleteElementState;
    }
    public void setSettingsState(){

        this.currState = settingsState;
    }
    public void setZoomState(){

        this.currState = zoomState;
    }
    public void setMoveElementState(){

        this.currState = moveElementState;
    }
    public void setZoomOutState(){

        this.currState = zoomOutState;
    }
    public void setSelectionState(){

        this.currState = selectionState;
    }
}
