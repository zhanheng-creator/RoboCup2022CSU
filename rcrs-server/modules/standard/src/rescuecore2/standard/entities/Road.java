package rescuecore2.standard.entities;

import org.json.JSONArray;
import org.json.JSONObject;
import rescuecore2.worldmodel.Entity;
import rescuecore2.worldmodel.EntityID;

/**
 * The Road object.
 */
public class Road extends Area {

  /**
   * Construct a Road object with entirely undefined property values.
   *
   * @param id
   *          The ID of this entity.
   */
  public Road( EntityID id ) {
    super( id );
  }


  /**
   * Road copy constructor.
   *
   * @param other
   *          The Road to copy.
   */
  public Road( Road other ) {
    super( other );
  }


  @Override
  protected Entity copyImpl() {
    return new Road( getID() );
  }


  @Override
  public StandardEntityURN getStandardURN() {
    return StandardEntityURN.ROAD;
  }


  @Override
  protected String getEntityName() {
    return "Road";
  }


  @Override
  public JSONObject toJson() {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put( "Id", this.getID() );
    jsonObject.put( "EntityName", this.getEntityName() );

    JSONArray edgesJson = new JSONArray();
    for ( Edge edge : this.getEdges() ) {
      edgesJson.put( edge.toJson() );
    }
    jsonObject.put( "Edges", edgesJson );

    return jsonObject;
  }
}
