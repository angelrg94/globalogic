package cl.globallogic.earthquake.model;

public class Feature {
	
	String type;
	String id;
	FeatureProperties properties;
	Geometry geometry;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public FeatureProperties getProperties() {
		return properties;
	}
	public void setProperties(FeatureProperties properties) {
		this.properties = properties;
	}
	public Geometry getGeometry() {
		return geometry;
	}
	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}
	
	

}
