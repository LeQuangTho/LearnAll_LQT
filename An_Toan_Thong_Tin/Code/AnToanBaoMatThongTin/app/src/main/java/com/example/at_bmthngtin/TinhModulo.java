package com.example.at_bmthngtin;

/*
 * Các phép toán với modulo:
 * Phép Cộng:    (a + b) mod n = [(a mod n) + (b mod n)] mod n.
 * Phép Trừ :    (a - b) mod n = [(a mod n) - (b mod n)] mod n.
 * Phép Nhân:    (a * b) mod n = [(a mod n) * (b mod n)] mod n.
 * Phép Chia:    (a + b) mod n = [(a mod n) * (b^(-1) mod n)] mod n.
 *
 * Nghịch đảo của b mod n
 * x * b mod n = 1 => x là nghịch đảo của b mod n
 *
 * Định lý Fermat:
 * 'n' là số nguyên tố && (a > 0)
 * Dạng 1: a^(n - 1) mod n = 1 mod n        ( a % n != 0 )
 * Dạng 2: a^n mod n = a mod n
 *
 * Định lý Euler:
 * Dạng 1: a^(φ(n)) mod n =  1 mod n        ( a & n là số nguyên tố cùng nhau )
 * Dạng 2: a^(φ(n) + 1) mod n = a mod n     ( a & n là hai số nguyên )
 *
 * Tính phi:
 * φ(p)    = p - 1             ( p là số nguyên tố )
 * φ(p*q)  = φ(p)*φ(q)         ( p, q là số nguyên tố cùng nhau )
 * φ(p^m)  = p^m - p^(m-1)     ( p là số nguyên tố, m là số nguyên dương )
 *
 * Số nguyên tố cùng nhau:
 * - Các số nguyên a và b được gọi là nguyên tố cùng nhau (tiếng Anh: coprime hoặc relatively prime) nếu chúng có Ước số chung lớn nhất là 1
 *
 * */


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TinhModulo {
    // Hạ Bậc Lũy Thừa Modulo
    public int power(int x, int y, int p) {
        int res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) != 0) // nếu y lẻ thì res = x* res
                res = (res * x) % p;
            y = y >> 1; // gán y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    // tìm ước số chung
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Tính Hàm Euler (Phi)
    public int phi(int n) {
        int result = 1;
        for (int i = 2; i < n; i++)
            if (gcd(i, n) == 1)
                result++;
        return result;
    }


    // Tính nghịch đảo modulo
    public int modulo_inverse(int a, int n) {
        for (int i = 1; i < n; i++) {
            if (((long) a * i) % n == 1) {
                return i;
            }
        }
        return -1;
    }

    // Kiểm tra số nguyên tố
    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Kiểm tra số nguyên tố cung nhau
    public boolean coprime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Fermat
    public int Fermat(int a, int b, int n) {
        int b1;
        if (isPrime(n) && a > 0) {
            b1 = b % (n - 1);
            return power(a, b1, n);
        }
        return -1;
    }

    // Euler
    public int Euler(int a, int b, int n) {
        int b1, amountA;
        if (coprime(a, n)) {
            b1 = b % phi(n);
            return power(a, b1, n);
        } else {
            amountA = (int) b / (phi(n) + 1);
            b1 = (b % (phi(n) + 1)) + amountA;
            return power(a, b1, n);
        }
    }

    // Kiểm tra Căn Nguyên Thủy
    public boolean isCanNguyenThuy(int a, int n) {
        int phiN = phi(n);
        if (1 == power(a, phiN, n)) {
            for (int i = 1; i < phiN; i++) {
                if (phiN % i == 0) {
                    if (1 == power(a, i, n)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    // Tìm logarit rời rạc
    public int logarithmRoiRac(int a, int b, int n) {
        for (int i = 1; i < n; i++) {
            if (b == power(a, i, n)) {
                return i;
            }
        }
        return -1;
    }

    // Số dư Trung Hoa
    public int soDuTrungHoa(int[] a, int[] m, int n) {
        int M = 1;
        for (int i = 0; i < n; i++) {
            M *= m[i];
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * (M / m[i]) * modulo_inverse(M / m[i], m[i]);
        }
        return (int) sum % M;
    }

    // Các phép toán Modulo cơ bản
    public String Modulo(int a, int b, int x, int y, int n) {
        int A1, A2, A3, A4, A5;
        A1 = (power(a, x, n) + power(b, y, n)) % n;
        A2 = (power(a, x, n) - power(b, y, n) + n) % n;
        A3 = (power(a, x, n) * power(b, y, n)) % n;
        A4 = modulo_inverse(power(b, y, n), n);
        A5 = (power(a, x, n) * A4) % n;
        return "A1 = " + A1 + "\nA2 = " + A2 + "\nA3 = " + A3 + "\nA4 = " + A4 + "\nA5 = " + A5;
    }


    public static List<Integer> phanTichSoNguyen(int n) {
        int i = 2;
        List<Integer> listNumbers = new ArrayList<Integer>();
        // phân tích
        while (n > 1) {
            if (n % i == 0) {
                n = n / i;
                listNumbers.add(i);
            } else {
                i++;
            }
        }
        // nếu listNumbers trống thì add n vào listNumbers
        if (listNumbers.isEmpty()) {
            listNumbers.add(n);
        }
        return listNumbers;
    }

    public int soDuTrungHoa2(int a, int M, int n) {
//        int M = 1;
        List<Integer> listNumbers = phanTichSoNguyen(n);
        int[] A = new int[20];
        int size2 = listNumbers.size();
        for (int i = 0; i < size2; i++) {
            A[i] = power(a, M, listNumbers.get(i));
        }

//        for (int i = 0; i < n; i++) {
//            M *= m[i];
//        }
        long sum = 0;
        for (int i = 0; i < size2; i++) {
            sum += A[i] * ((n / listNumbers.get(i)) * modulo_inverse(n / listNumbers.get(i), listNumbers.get(i)));
        }
        return (int) sum % n;
    }

}
