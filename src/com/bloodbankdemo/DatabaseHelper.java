package com.bloodbankdemo;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat tag
	private static final String LOG = "DatabaseHelper";

	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "blood";

	// Table Names
	private static final String TABLE_BLOOD_REGISTRATION = "blood_registration";

	// Common Column names
	private static final String KEY_ID = "id";
	private static final String KEY_FNAME = "fname";
	private static final String KEY_LNAME = "lname";
	private static final String KEY_SEX = "sex";
	private static final String KEY_DOB = "dob";

	private static final String KEY_BlOOD_GROUP = "bloodgroup";

	private static final String KEY_PHONE = "phone";
	private static final String KEY_CITY = "city";
	private static final String KEY_STATE = "state";
	private static final String KEY_COUNTRY = "country";

	// Column names for student registration
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_USERNAME = "username";
	private static final String KEY_PASSWORD = "password";

	// Table Create Statements
	// Todo table create statement
	private static final String CREATE_TABLE_BLOOD = "CREATE TABLE " + TABLE_BLOOD_REGISTRATION + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY," + KEY_FNAME + " TEXT," + KEY_LNAME + " TEXT," + KEY_SEX + " TEXT," + KEY_DOB
			+ " TEXT," + KEY_BlOOD_GROUP + " TEXT," + KEY_PHONE + " TEXT," + KEY_CITY + " TEXT," + KEY_COUNTRY
			+ " TEXT," + KEY_STATE + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_USERNAME + " TEXT," + KEY_PASSWORD
			+ " TEXT" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// creating required tables
		db.execSQL(CREATE_TABLE_BLOOD);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_BLOOD);

		// create new tables
		onCreate(db);
	}

	public long createStudentegistraton(User register) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_FNAME, register.getFname());
		values.put(KEY_LNAME, register.getLname());
		values.put(KEY_DOB, register.getDob());
		values.put(KEY_SEX, register.getSex());
		values.put(KEY_BlOOD_GROUP, register.getBloodGroup());
		values.put(KEY_CITY, register.getCity());
		values.put(KEY_COUNTRY, register.getCountry());
		values.put(KEY_PHONE, register.getPhno());
		values.put(KEY_ADDRESS, register.getAddress());
		values.put(KEY_USERNAME, register.getUsername());
		values.put(KEY_PASSWORD, register.getPassword());
		values.put(KEY_STATE, register.getState());

		// insert row
		long todo_id = db.insert(TABLE_BLOOD_REGISTRATION, null, values);

		return todo_id;
	}

	public User getStudentLogin(String username, String password) {

		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT *FROM " + TABLE_BLOOD_REGISTRATION + " WHERE " + KEY_USERNAME + "='" + username
				+ "' AND " + KEY_PASSWORD + "='" + password + "'";

		Cursor c = db.rawQuery(selectQuery, null);
		User register = new User();
		if (c != null)
			c.moveToFirst();
		register.setSno(c.getString(c.getColumnIndex(KEY_ID)));
		register.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
		return register;
	}

	public User getStudentLogin(String sno) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT *FROM " + TABLE_BLOOD_REGISTRATION + " WHERE " + KEY_ID + "=" + sno;

		Cursor c = db.rawQuery(selectQuery, null);
		User register = new User();
		if (c != null)
			c.moveToFirst();
		register.setSno(c.getString(c.getColumnIndex(KEY_ID)));
		register.setFname(c.getString(c.getColumnIndex(KEY_FNAME)));
		register.setPhno(c.getString(c.getColumnIndex(KEY_PHONE)));
		register.setSex(c.getString(c.getColumnIndex(KEY_SEX)));
		register.setBloodGroup(c.getString(c.getColumnIndex(KEY_BlOOD_GROUP)));
		register.setDob(c.getString(c.getColumnIndex(KEY_DOB)));
		register.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
		register.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
		register.setState(c.getString(c.getColumnIndex(KEY_STATE)));

		register.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		register.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
		register.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
		return register;
	}

	public void updateTheValues(String id, String address, String phoneno, String city, String state, String country,
			String password) {

		String selectQuery = "UPDATE  " + TABLE_BLOOD_REGISTRATION + " SET " + KEY_ADDRESS + "='" + address + "',"
				+ KEY_PHONE + "='" + phoneno + "'," + KEY_PASSWORD + "='" + password + "'," + KEY_CITY + "='" + city
				+ "'," + KEY_STATE + "='" + state + "'," + KEY_COUNTRY + "='" + country + "' WHERE " + KEY_ID + "='"
				+ id + "'";
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL(selectQuery);
	}

	public void deleteThevalue(String sno) {
		String selectQuery = "DELETE FROM " + TABLE_BLOOD_REGISTRATION + " WHERE " + KEY_ID + "=" + sno;
		SQLiteDatabase db = this.getReadableDatabase();
		db.execSQL(selectQuery);
	}

	public int checkAvailibilityOfBlood(String blood) {
		ArrayList<User> list = new ArrayList<User>();
		SQLiteDatabase db = this.getReadableDatabase();
		try {
			
		
		String selectQuery = "SELECT  *FROM " + TABLE_BLOOD_REGISTRATION + " WHERE "
				+ KEY_BlOOD_GROUP + "='" + blood + "'";

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null)
			c.moveToFirst();
		User register = new User();
		register.setSno(c.getString(c.getColumnIndex(KEY_ID)));
		register.setFname(c.getString(c.getColumnIndex(KEY_FNAME)));
		register.setPhno(c.getString(c.getColumnIndex(KEY_PHONE)));
		register.setSex(c.getString(c.getColumnIndex(KEY_SEX)));
		register.setBloodGroup(c.getString(c.getColumnIndex(KEY_BlOOD_GROUP)));
		register.setDob(c.getString(c.getColumnIndex(KEY_DOB)));
		register.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
		register.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
		register.setState(c.getString(c.getColumnIndex(KEY_STATE)));

		register.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		register.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
		register.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
		list.add(register);
		} catch (CursorIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		return list.size();
	}
}
