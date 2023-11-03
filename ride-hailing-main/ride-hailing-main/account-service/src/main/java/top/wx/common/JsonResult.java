package top.wx.common;

import lombok.Data;

import java.security.SecureRandom;
import java.util.Random;

@Data
public class JsonResult {
	
	//响应状态码
	private Integer status;
	
	//响应消息
	private String msg;
	
	//响应数据
	private Object data;

	private String requestId;

	private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int ID_LENGTH = 12; // Specify your desired length

	public static String generateRequestId() {
		SecureRandom random = new SecureRandom();
		StringBuilder requestId = new StringBuilder(ID_LENGTH);

		for (int i = 0; i < ID_LENGTH; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(randomIndex);
			requestId.append(randomChar);
		}

		return requestId.toString();
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public JsonResult(Integer status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public JsonResult(Object data) {
		super();
		this.status = 200;
		this.msg = "OK";
		this.data = data;
		this.requestId = generateRequestId();
	}
	
	public JsonResult() {
		super();
	}

	public static JsonResult build(Integer status,String msg,Object data) {
		return new JsonResult(status,msg,data);
	}
	
	public static JsonResult buildData(Object data) {
		return new JsonResult(data);
	}

	public static JsonResult buildFailure(String msg) {
		JsonResult jsonResult = new JsonResult();
		jsonResult.setMsg(msg);
		jsonResult.setStatus(500);
		return jsonResult;
	}

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }
	
	
}
