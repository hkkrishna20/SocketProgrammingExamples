package name.javacode.xml.security.dsig;

import java.io.File;
import java.security.KeyPair;

import name.javacode.xml.security.KeyStoreManager;
import name.javacode.xml.security.SecurityUtil;

public class XMLSigner {

	public void sign(String inputFile, String outputFile, String referenceURI)
			throws Exception {
		File ipFile = new File(inputFile);
		File opFile = new File(outputFile);

		SecurityUtil.print(ipFile);

		KeyPair keyPair = KeyStoreManager.getKeyPair(XMLSigner.class
				.getResource("/" + KEYSTORE).getPath(), STORE_PASSWORD,
				KEY_PASSWORD, ALIAS);

		SignatureManager sigMgr = new SignatureManager(keyPair, XMLSigner.class
				.getResource("/" + CERTIFICATE).getPath(), referenceURI);

		sigMgr.sign(ipFile, opFile);

		SecurityUtil.print(opFile);
	}

	public void validate(String inputFile) throws Exception {
		File signedFile = new File(inputFile);
		KeyPair keyPair = KeyStoreManager.getKeyPair(XMLSigner.class
				.getResource("/" + KEYSTORE).getPath(), STORE_PASSWORD,
				KEY_PASSWORD, ALIAS);

		SignatureManager sigMan = new SignatureManager(keyPair, XMLSigner.class
				.getResource("/" + CERTIFICATE).getPath(), null);

		sigMan.validate(signedFile);
	}

	private static final String KEYSTORE = ".ocewsdkeystore";
	private static final String STORE_PASSWORD = "javacode";
	private static final String KEY_PASSWORD = "javacode";
	private static final String ALIAS = "xmlsig";
	private static final String CERTIFICATE = "xmlsig.cer";

}
