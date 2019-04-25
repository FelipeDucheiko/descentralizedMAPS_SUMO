package proposal;

import cartago.*;

public class ProposalGenerator extends Artifact {
	void init(int initialValue) {
		defineObsProperty("count", initialValue);
	}

	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}
	
	@OPERATION
	void generateOffer(Object maxValue, Object maxDistance, Object locationParkedSpotX, Object locationParkedSpotY, Object targetLocationX, Object targetLocationY, OpFeedbackParam<Object> offer) {
		double o = (Integer.parseInt(maxValue.toString())) - (Math.sqrt(Math.pow(Double.parseDouble(locationParkedSpotX.toString()) - Double.parseDouble(targetLocationX.toString()), 2) + Math.pow(Double.parseDouble(locationParkedSpotY.toString()) - Double.parseDouble(targetLocationY.toString()), 2)))/(Double.parseDouble(maxDistance.toString()));
		offer.set(o);
	}
	
	
}

