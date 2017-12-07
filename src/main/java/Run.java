import java.nio.charset.Charset;

/**
 * Created by clz on 2017/12/7.
 */

public class Run {
    private static final Charset utf8Charset = Charset.forName("UTF-8");


    private void doString(String s) {
        doString(s, 0, 0);
    }

    private static void doString(String s, int pre, int post) {

        byte[] utf8 = s.getBytes(utf8Charset);
        int hash1 = Murmurhash3.murmurhash3_x86_32(utf8, pre, utf8.length-pre-post, 123456789);
        int hash2 = Murmurhash3.murmurhash3_x86_32(s, pre, s.length()-pre-post, 123456789);

        Murmurhash3.LongPair result = new Murmurhash3.LongPair();
        Murmurhash3.murmurhash3_x64_128(utf8, pre, utf8.length-pre-post, 0,result);
        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(result.val1);
        System.out.println(result.val2);
    }


    public static void main(String[] args) {
        doString("foo",0,0);
    }

}
