package rescuecore2.messages.components;

import static rescuecore2.misc.EncodingTools.readInt32;
import static rescuecore2.misc.EncodingTools.writeInt32;

import rescuecore2.messages.AbstractMessageComponent;
import rescuecore2.worldmodel.EntityID;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

/**
   An EntityID component to a message.
 */
public class EntityIDComponent extends AbstractMessageComponent {
    private EntityID value;

    /**
       Construct an EntityIDComponent with no content.
       @param name The name of the component.
     */
    public EntityIDComponent(String name) {
        super(name);
        value = null;
    }

    /**
       Construct an EntityIDComponent with a specific value.
       @param name The name of the component.
       @param value The value of this component.
     */
    public EntityIDComponent(String name, EntityID value) {
        super(name);
        this.value = value;
    }

    /**
       Get the value of this message component.
       @return The value of the component.
     */
    public EntityID getValue() {
        return value;
    }

    /**
       Set the value of this message component.
       @param id The new value of the component.
     */
    public void setValue(EntityID id) {
        value = id;
    }

    @Override
    public void write(OutputStream out) throws IOException {
        writeInt32(value.getValue(), out);
    }

    @Override
    public void read(InputStream in) throws IOException {
        value = new EntityID(readInt32(in));
    }

    @Override
    public String toString() {
        return getName() + " = " + value;
    }
}
