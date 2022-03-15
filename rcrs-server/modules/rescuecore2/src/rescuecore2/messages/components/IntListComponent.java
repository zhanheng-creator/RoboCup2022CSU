package rescuecore2.messages.components;

import static rescuecore2.misc.EncodingTools.readInt32;
import static rescuecore2.misc.EncodingTools.writeInt32;

import rescuecore2.messages.AbstractMessageComponent;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
   A message component that is a list of integers.
 */
public class IntListComponent extends AbstractMessageComponent {
    private List<Integer> data;

    /**
       Construct an IntListComponent with no data.
       @param name The name of the component.
     */
    public IntListComponent(String name) {
        super(name);
        data = new ArrayList<Integer>();
    }

    /**
       Construct an IntListComponent with a list of integers.
       @param name The name of the component.
       @param data The data.
     */
    public IntListComponent(String name, List<Integer> data) {
        super(name);
        this.data = new ArrayList<Integer>(data);
    }

    /**
       Get the list of Integers in this component.
       @return An immutable view of the list of Integers.
     */
    public List<Integer> getValues() {
        return Collections.unmodifiableList(data);
    }

    /**
       Set the list of values in this component.
       @param newData The new set of values.
     */
    public void setValues(List<Integer> newData) {
        this.data = new ArrayList<Integer>(newData);
    }

    /**
       Set the list of values in this component.
       @param newData The new set of values.
     */
    public void setValues(int... newData) {
        this.data = new ArrayList<Integer>();
        for (int i : newData) {
            data.add(i);
        }
    }

    @Override
    public void write(OutputStream out) throws IOException {
        writeInt32(data.size(), out);
        for (Integer next : data) {
            writeInt32(next.intValue(), out);
        }
    }

    @Override
    public void read(InputStream in) throws IOException {
        data.clear();
        int count = readInt32(in);
        for (int i = 0; i < count; ++i) {
            data.add(readInt32(in));
        }
    }

    @Override
    public String toString() {
        return getName() + " = " + data.toString();
    }
}
