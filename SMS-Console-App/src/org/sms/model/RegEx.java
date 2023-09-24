package org.sms.model;

public class RegEx {
	public static final String NAME = "[A-Za-z]*";
	public static final String EMAIL = "^(.+)@(.+)$";
	public static final String PHNO = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
			+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	public static final String ADDRESS = "[A-Za-z]*";
}