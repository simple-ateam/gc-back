package com.ateam.gc.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.security.SignatureException;

class Signatures {

	static {
		Security.addProvider(new BouncyCastleProvider());
	}

	private static final String PROVIDER = "BC";
	private static final String HMAC_SHA256 = "HMac-SHA256";

	static String of(String timestamp, String method, String resource, String key) throws SignatureException {
		return of(timestamp + "." + method + "." + resource, key);
	}

	private static String of(String data, String key) throws SignatureException {
		try {
			Mac mac = Mac.getInstance(HMAC_SHA256, PROVIDER);
			mac.init(new SecretKeySpec(key.getBytes(), HMAC_SHA256));
			return DatatypeConverter.printBase64Binary(mac.doFinal(data.getBytes()));
		} catch (GeneralSecurityException e) {
			throw new SignatureException("Failed to generate signature.", e);
		}
	}

}
