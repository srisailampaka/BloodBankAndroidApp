package com.bloodbankdemo;

public interface ResultListener<T> {

	public void onSuccess(T result);

	public void onFailure(Throwable e);

}