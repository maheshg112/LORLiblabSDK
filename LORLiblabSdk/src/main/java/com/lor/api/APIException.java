package com.lor.api;

public class APIException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 90061391908078936L;
	private String code;
	
	public APIException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public APIException(String code, String message, Throwable cause) {
        super(message, cause);
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
