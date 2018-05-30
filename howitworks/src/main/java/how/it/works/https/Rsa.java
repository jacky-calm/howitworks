package how.it.works.https;


import java.math.BigInteger;

/**
 * Created by I311682 on 3/21/18.
 */
public class Rsa {
    public static void main(String[] args) {
        BigInteger m = new BigInteger("42");
        int d = 2753; // private key, decrypt power

        // e and n are the public key
        int e = 17; // encrypt power
        BigInteger n = new BigInteger("3233"); // modular which is used in both encrypting and decrypting

        System.out.println(m);
        System.out.println(m.pow(e));

        BigInteger c = m.pow(e).mod(n); // encrypt m^e mod n = c, cipher message text
        System.out.println(c);
        BigInteger dm = c.pow(d).mod(n); // decrypt c^d mod n = m, origin message text
        System.out.println(m);
        System.out.println(dm);
    }
}
