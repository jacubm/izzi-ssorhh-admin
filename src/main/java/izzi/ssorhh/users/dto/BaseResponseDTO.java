package izzi.ssorhh.users.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseResponseDTO {

	SimpleDateFormat datePaymentFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private Long resultCode;
	private String resultDescription;
	private String resultDate;

	public Long getResultCode() {
		return resultCode;
	}

	public void setResultCode(Long resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public String getResultDate() {
		return datePaymentFormat.format(new Date());
	}

	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}
}
