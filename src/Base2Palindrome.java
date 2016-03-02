import static java.lang.Math.pow;

import java.util.Scanner;

public class Base2Palindrome {

    public static void main(String[] args) throws Exception {
        try (final Scanner in = new Scanner(System.in)) {
            System.out.println(A006995(in.nextInt() + 1));
        }
    }

    private static long A006995(final int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int p = -1, q = -1, m = -1;

            // k:=floor(log_2(n-1))
            final long k = binlog(n-1);
            final long _2k = (long) pow(2, k);
            final long _2kp1 = _2k*2;
            final long _2km1 = _2k/2;

            // Case 1: If n=2^(k+1), then p=0, q=0, m=1;
            if (n == _2kp1) {
                p = 0; q = 0; m = 1;
            }

            // Case 2: If 2^k<n<2^k+2^(k-1), then set i:=n-2^k, p=k-floor(log_2(i))-1, q=2, m=2^floor(log_2(i))+i;
            else if ((_2k < n) && (n < (_2k + _2km1))) {
                final long ii = n - _2k;
                final long l2 = binlog(ii);
                p = (int) (k - l2 - 1);
                q = 2;
                m = (int) (pow(2, l2) + ii);
            }

            // Case 3: If n=2^k+2^(k-1), then p=0, q=1, m=1;
            else if (n == (_2k + _2km1)) {
                p = 0;
                q = 1;
                m = 1;
            }

            // Case 4: If 2^k+2^(k-1)<n<2^(k+1), then set j:=n-2^k-2^(k-1), p=k-floor(log_2(j))-1, q=1, m=2*2^floor(log_2(j))+j;
            else if ((n > (_2k + _2km1)) && (n < _2kp1)) {
                final long jj = n - _2k - _2km1;
                final long l2 = binlog(jj);

                p = (int) (k - l2 - 1);
                q = 1;
                m = (int) (2 * pow(2, l2) + jj);
            }

            return (long) (pow(2, 2*k - q) + 1 + pow(2, p) * A006995(m));
        }
    }

    private static long binlog(long bits) {
        long log = 0;
        if (( bits & 0xffff0000 ) != 0 ) { bits >>>= 16; log = 16; }
        if (bits >= 256 ) { bits >>>= 8; log += 8; }
        if (bits >= 16  ) { bits >>>= 4; log += 4; }
        if (bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + (bits >>> 1);
    }
}