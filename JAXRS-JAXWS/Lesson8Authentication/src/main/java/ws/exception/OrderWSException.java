package ws.exception;

public class OrderWSException extends Exception {

	private String errorCode;
	private String erroDesc;

	public OrderWSException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public OrderWSException(String errorCode, String erroDesc) {
		super();
		this.errorCode = errorCode;
		this.erroDesc = erroDesc;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErroDesc() {
		return erroDesc;
	}

	public void setErroDesc(String erroDesc) {
		this.erroDesc = erroDesc;
	}

}
