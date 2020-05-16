Generate a DSA public-private keypair:
keytool -genkeypair -v -alias xmlsig -sigalg DSA   javacode -keystore .ocewsdkeystore -storepass javacode -storetype JCEKS

Delete the above generated keypair (does not delete the keystore file):
keytool -delete -v -alias xmlsig -keystore .ocewsdkeystore -storepass javacode -storetype JCEKS

Export a certificate:
keytool -exportcert -v -alias xmlsig -file ./xmlsig.cer -keystore .ocewsdkeystore -storepass javacode -storetype JCEKS

Generate a AES seckey:
keytool -genseckey -v -alias xmlenc -keypass javacode -keyalg AES -keysize 128 -sigalg DSA -keystore .ocewsdkeystore -storepass javacode -storetype JCEKS

List keys in key store:
keytool -list -v -keystore .ocewsdkeystore -storepass javacode -storetype JCEKS