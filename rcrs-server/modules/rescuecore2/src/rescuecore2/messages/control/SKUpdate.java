package rescuecore2.messages.control;

import rescuecore2.messages.Control;
import rescuecore2.messages.AbstractMessage;
import rescuecore2.messages.components.IntComponent;
import rescuecore2.messages.components.ChangeSetComponent;
import rescuecore2.worldmodel.ChangeSet;

import java.io.InputStream;
import java.io.IOException;

/**
   A message for sending updates from a simulator to the kernel.
 */
public class SKUpdate extends AbstractMessage implements Control {
    private IntComponent id;
    private IntComponent time;
    private ChangeSetComponent update;

    /**
       An SKUpdate message that populates its data from a stream.
       @param in The InputStream to read.
       @throws IOException If there is a problem reading the stream.
     */
    public SKUpdate(InputStream in) throws IOException {
        this();
        read(in);
    }

    /**
       SKUpdate message with a specific ID and data component.
       @param id The id of the simulator sending the update.
       @param time The timestep this update refers to.
       @param changes The changeset.
     */
    public SKUpdate(int id, int time, ChangeSet changes) {
        this();
        this.id.setValue(id);
        this.time.setValue(time);
        this.update.setChangeSet(changes);
    }

    private SKUpdate() {
        super(ControlMessageURN.SK_UPDATE);
        id = new IntComponent("ID");
        time = new IntComponent("Time");
        update = new ChangeSetComponent("Changes");
        addMessageComponent(id);
        addMessageComponent(time);
        addMessageComponent(update);
    }

    /**
       Get the ID of the simulator that is acknowledging the connection.
       @return The simulator ID component.
     */
    public int getSimulatorID() {
        return id.getValue();
    }

    /**
       Get the list of changes.
       @return The ChangeSet.
     */
    public ChangeSet getChangeSet() {
        return update.getChangeSet();
    }

    /**
       Get the timestep this update is for.
       @return The timestep.
     */
    public int getTime() {
        return time.getValue();
    }
}
