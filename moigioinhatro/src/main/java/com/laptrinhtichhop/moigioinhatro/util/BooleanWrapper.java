package com.laptrinhtichhop.moigioinhatro.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BooleanWrapper {
	private boolean result;

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
}
