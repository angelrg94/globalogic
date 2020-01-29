package cl.globallogic.earthquake.model;

import java.util.List;

public class Response {

	String type;
	Metadata metadata;
	List<Feature> features;
	List<Double> bbox;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
	public List<Double> getBbox() {
		return bbox;
	}
	public void setBbox(List<Double> bbox) {
		this.bbox = bbox;
	}
	
	
}
