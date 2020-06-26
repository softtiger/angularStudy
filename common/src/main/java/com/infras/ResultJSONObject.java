package com.infras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ResultJSONObject extends JSONObject {

	private static final long serialVersionUID = 6305779772613611507L;

	public ResultJSONObject() {

    }

	public ResultJSONObject(RespCode resp,boolean orderd) {
		    super(true);
	        super.put("resultCode", resp.getCode()+"");
	        super.put("message", resp.getMessage());
	        super.put("reason", resp.getReason());
	        super.put("data", new ArrayList<>());
	}
	public ResultJSONObject(RespCode resp) {
			this(resp,false);
	}
	
	public ResultJSONObject(RespCode resp,String value,boolean ordered) {
	    super(ordered);
        super.put("resultCode", resp.getCode()+"");
        if (resp.getCode()==400) {
        		//对于包含特殊字符的，消息和原因取相同值
        		super.put("message", resp.toString(value));
        		super.put("reason", super.get("message"));
        }else {
        		super.put("message", resp.getMessage());
        		super.put("reason", resp.toString(value));
        }
        super.put("data", new ArrayList());
	}
	
	public ResultJSONObject(RespCode resp,String value) {
	     this(resp,value,false);
	}
	
    public ResultJSONObject(String resultCode, String message) {
        super();
        super.put("resultCode", resultCode);
        super.put("message", message);
        super.put("data", new ArrayList());
    }
    
    
    public List getData(){
    	return (List)get("data");
    }
    
    
    public String getResultCode() {
    	 return (String) get("resultCode");
    }
    
    
    public void setResultCode(String code) {
    	   super.put("resultCode", code);
    }
    
    public void setMessage(String msg) {
 	   super.put("message", msg);
   }
    
    public String getMessage() {
    	return (String) super.get("message");
    }
    
    public void setReason(String reason) {
  	   super.put("reason", reason);
    }
    
    public void  setId(String id) {
    	super.put("id", id);
    }
    
    public String getId() {
    	return (String) get("id");
    }
    
    
    public void setDesc(String desc) {
    	 super.put("desc", desc);
    }
    
    public String getDesc() {
    	return (String) get("desc");
   }
    
    public boolean isSuccess() {
    	return get("resultCode").equals(RespCode.SUCCESS.getCode()+"");
    }
}
