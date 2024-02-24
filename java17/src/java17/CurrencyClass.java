package java17;

import java.util.Currency;
import java.util.Locale;

public class CurrencyClass {
	public static void main(String[] args) {
		Currency us = Currency.getInstance(Locale.US);
		String usdCode = us.getCurrencyCode();
		String usdSymbol = us.getSymbol();
		System.out.println(usdCode + ": " + usdSymbol); // USD: $
		
		Currency uk = Currency.getInstance(Locale.UK);
		String ukCode = uk.getCurrencyCode();
		String ukSymbol = uk.getSymbol();
		System.out.println(ukCode + ": " + ukSymbol); // GBP: £
		
		Currency japan = Currency.getInstance(Locale.JAPAN);
		String japanCode = japan.getCurrencyCode();
		String japanSymbol = japan.getSymbol();
		System.out.println(japanCode + ": " + japanSymbol); // JPY: ¥
	}
}
