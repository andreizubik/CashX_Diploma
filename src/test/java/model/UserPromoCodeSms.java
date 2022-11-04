package model;

import lombok.Data;

@Data
public class UserPromoCodeSms{
	private Object result;
	private Object calledAt;
	private Object operator;

	public Object getResult(){
		return result;
	}

	public Object getCalledAt(){
		return calledAt;
	}

	public Object getOperator(){
		return operator;
	}
}
