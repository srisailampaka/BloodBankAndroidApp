package com.bloodbankdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	
	public String email(String emailId){
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	
	if(emailId.equals("")){
		emailId = "empty";
		
	}else if(!emailId.matches(emailPattern)){
		emailId = "inValid";
	}else{
		emailId = "valid";
	}
	return emailId;
}

public String userName(String userName){
	String namePattern = "[a-zA-Z ]*";
	if(userName.equals("")){
		userName = "empty";
	}else if(userName.length() < 3 || userName.length() >15){
		userName = "nameLength";
	}else if(!userName.matches(namePattern)){
		userName = "inValid";
	}else{
		userName = "valid";
	}
	return userName;
}

public String password(String userPassword){
	
	Pattern pswNamePtrn =
	        Pattern.compile("((?=.*[a-z])(?=\\S+$).{2,15})");
			Matcher mtch = pswNamePtrn.matcher(userPassword);
	if(userPassword.equals("")){
		userPassword = "empty";
	}else if(userPassword.length() < 6){
		userPassword = "passwordLength";
		
	}else if(!mtch.matches()){
		userPassword = "inValid";
	}else{
		userPassword = "valid";
	}
	return userPassword;
	
}

public String phoneNumber(String phoneNumber){
	
	String  mobilePattern = "^[+]?[0-9]{10,13}$";
	if(phoneNumber.equals("")){
		phoneNumber = "empty";
	}else if(phoneNumber.length() < 10 || phoneNumber.length()>13){
		phoneNumber = "numberLength";
	}else if(!phoneNumber.matches(mobilePattern)){
		phoneNumber = "inValid";
	}else{
		phoneNumber = "valid";
	}
	return phoneNumber;
	
	
}
}
