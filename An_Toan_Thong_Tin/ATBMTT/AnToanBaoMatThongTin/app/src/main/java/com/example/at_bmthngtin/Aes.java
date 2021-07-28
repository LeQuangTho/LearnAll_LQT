package com.example.at_bmthngtin;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Aes {
    int size = 256;
    String[] S = {"63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76",
            "CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0",
            "B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15",
            "04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75",
            "09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84",
            "53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF",
            "D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8",
            "51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2",
            "CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73",
            "60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB",
            "E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79",
            "E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08",
            "BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A",
            "70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E",
            "E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF",
            "8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16"
    };

    String[] Rc = {"8D", "01", "02", "04", "08", "10", "20", "40", "80", "1B", "36", "6C", "D8", "AB", "4D", "9A",
            "2F", "5E", "BC", "63", "C6", "97", "35", "6A", "D4", "B3", "7D", "FA", "EF", "C5", "91", "39"};

    @RequiresApi(api = Build.VERSION_CODES.O)
    String hextoBin(String input) { // Chuyển hexa sang nhị phân
        int n = input.length() * 4;
        input = Long.toBinaryString(
                Long.parseUnsignedLong(input, 16));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String binToHex(String input) { // chuyển nhị phân sang hexa
        int n = (int) input.length() / 4;
        input = Long.toHexString(
                Long.parseUnsignedLong(input, 2));
        while (input.length() < n)
            input = "0" + input;
        return input;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String permutation(int[] pc, String input) { // thực hiện hóa vị PC1 || PC2
        String output = "";
        input = hextoBin(input); // chuyển sang nhị phân
        for (int i = 0; i < pc.length; i++)
            output += input.charAt(pc[i] - 1); //thực hiện hoán vị
        output = binToHex(output); // chuyển về hexa
        return output;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String xor(String a, String b) { // Thực hiện phép XOR 0&0 = 0 ; 0&1 = 1
        long t_a = Long.parseUnsignedLong(a, 16);
        long t_b = Long.parseUnsignedLong(b, 16);
        t_a = t_a ^ t_b;
        a = Long.toHexString(t_a);
        while (a.length() < b.length())
            a = "0" + a;
        return a;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    String leftCircularShift(String input, int numBits) { // dịch vòng trái
        int n = input.length() * 4;
        int perm[] = new int[n];
        for (int i = 0; i < n - 1; i++)
            perm[i] = (i + 2);
        perm[n - 1] = 1; // măng perm chứa vị trí khi dịch trái 1 bit
        while (numBits-- > 0)
            input = permutation(perm, input);
        return input;
    }

    String RotWord(String w) {
        w += w.substring(0, 2);
        return w.substring(2, 10);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String SubWord(String w) {
        String ds = "";
        for (int i = 0; i < w.length(); i += 2) {
            int a = Integer.parseInt(hextoBin(w.charAt(i) + ""), 2); // BIN to DEC
            int b = Integer.parseInt(hextoBin(w.charAt(i + 1) + ""), 2);
            ds += S[16 * a + b];
        }
        return ds;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String G(String w, int j) {
        String rotW = leftCircularShift(w, 8);
        String subW = SubWord(rotW);
        String kq = xor(subW, Rc[j] + "000000");
        return kq;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] KeyExpansion(String[] w) {
        String[] w2 = new String[44];
        w2[0] = w[0];
        w2[1] = w[1];
        w2[2] = w[2];
        w2[3] = w[3];
        for (int i = 4; i < 44; i++) {
            if (i % 4 == 0)
                w2[i] = xor(G(w2[i - 1], i / 4), w2[i - 4]);
            else {
                w2[i] = xor(w2[i - 1], w2[i - 4]);
            }
        }
        return w2;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] AddRoundKey(String[] state, String[] w) {
        String[] kq = new String[4];
        kq[0] = xor(state[0], w[0]);
        kq[1] = xor(state[1], w[1]);
        kq[2] = xor(state[2], w[2]);
        kq[3] = xor(state[3], w[3]);
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] SubBytes(String[] state) {
        String[] kq = new String[4];
        for (int i = 0; i < 4; i++)
            kq[i] = SubWord(state[i]);
        return kq;
    }

    String[] ShiftRows(String[] state) {
        String[] kq = new String[4];
        for (int i = 0; i < 4; i++) {
            String byte1 = state[i].substring(0, 2);
            String byte2 = state[(i + 1) % 4].substring(2, 4);
            String byte3 = state[(i + 2) % 4].substring(4, 6);
            String byte4 = state[(i + 3) % 4].substring(6, 8);
            kq[i] = byte1 + byte2 + byte3 + byte4;
        }
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String Nhan2(String w) {
        String kq = binToHex(hextoBin(w)+"0");
        if (Integer.parseInt(hextoBin(kq), 2) >= size) kq = xor(kq, "11B");
        String substring = kq.substring(kq.length() - 2);
        String substring1 = substring;
        return substring1;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String Nhan3(String w) {
        String kq = xor(w, Nhan2(w));
        return kq.substring(0, 2);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String xor4(String a, String b, String c, String d) { // Thực hiện phép XOR 0&0 = 0 ; 0&1 = 1
        long t_a = Long.parseUnsignedLong(a, 16);
        long t_b = Long.parseUnsignedLong(b, 16);
        long t_c = Long.parseUnsignedLong(c, 16);
        long t_d = Long.parseUnsignedLong(d, 16);
        t_a = t_a ^ t_b ^ t_c ^ t_d;
        a = Long.toHexString(t_a);
        while (a.length() < b.length())
            a = "0" + a;
        return a;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String NhanCot(String w) {
        String kq;
        String byte1 = w.substring(0, 2);
        String byte2 = w.substring(2, 4);
        String byte3 = w.substring(4, 6);
        String byte4 = w.substring(6, 8);
        String kq1 = xor4(Nhan2(byte1), Nhan3(byte2), byte3, byte4);
        String kq2 = xor4(byte1, Nhan2(byte2), Nhan3(byte3), byte4);
        String kq3 = xor4(byte1, byte2, Nhan2(byte3), Nhan3(byte4));
        String kq4 = xor4(Nhan3(byte1), byte2, byte3, Nhan2(byte4));
        kq = kq1 + kq2 + kq3 + kq4;
        return kq;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] MixColumns(String[] state) {
        String[] kq = new String[4];
        for (int i = 0; i < 4; i++)
            kq[i] = NhanCot(state[i]);
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String[] MahoaAES(String[] state, String[] key)
    {
        String[] w = KeyExpansion(key);
        String[] w2 = {w[0],w[1],w[2],w[3]};
        state = AddRoundKey(state,w2);
        for(int j = 1; j <= 9; j++)
        {
            state = SubBytes(state);
            state = ShiftRows(state);
            state = MixColumns(state);
            String[] w3 = {w[j*4],w[1+j*4],w[2+j*4],w[3+j*4]};
            state = AddRoundKey(state,w3);
//            printf("\nVong %d:\n",j);ShowMatrix(state);

        }
        //Vong thu 10
        String[] w4 = {w[40],w[41],w[42],w[43]};
        state = SubBytes(state);
        state = ShiftRows(state);
        state = AddRoundKey(state,w4);
//        printf("\nVong 10:\n");	ShowMatrix(state);
        String[] kq = new String[4];
        kq = state;
        return kq;
    }

    // Giải Mã
    @RequiresApi(api = Build.VERSION_CODES.O)
    String Nhan9(String w)
    {
        String kq = xor(binToHex(hextoBin(w)+"000"), w);
        if(Integer.parseInt(hextoBin(kq), 2) > (size*4)) kq = xor(kq,"46C"); // 0x11b<<2 = 46c
        if(Integer.parseInt(hextoBin(kq), 2) > (size*2)) kq = xor(kq,"236"); // 0x11b<<1 = 236
        if(Integer.parseInt(hextoBin(kq), 2) > size) kq = xor(kq,"11B");
        kq = kq.substring(kq.length()-2);
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String NhanB(String w)
    {
        String kq = xor(binToHex(hextoBin(w)+"000"), binToHex(hextoBin(w)+"0"));
//        String kq = (w << 3) ^ (w << 1) ^ w;

        if(Integer.parseInt(hextoBin(kq), 2) > (size*4)) kq = xor(kq,"46C"); // 0x11b<<2 = 46c
        if(Integer.parseInt(hextoBin(kq), 2) > (size*2)) kq = xor(kq,"236"); // 0x11b<<1 = 236
        if(Integer.parseInt(hextoBin(kq), 2) > size) kq = xor(kq,"11B");
        kq = kq.substring(kq.length()-2);
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String NhanD(String w)
    {
        String kq = xor(xor(binToHex(hextoBin(w)+"000"), binToHex(hextoBin(w)+"00")),w);
//        unsigned int kq = (w << 3) ^ (w << 2) ^ w;
        if(Integer.parseInt(hextoBin(kq), 2) > (size*4)) kq = xor(kq,"46C"); // 0x11b<<2 = 46c
        if(Integer.parseInt(hextoBin(kq), 2) > (size*2)) kq = xor(kq,"236"); // 0x11b<<1 = 236
        if(Integer.parseInt(hextoBin(kq), 2) > size) kq = xor(kq,"11B");
        kq = kq.substring(kq.length()-2);
        return kq;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String NhanE(String w)
    {
        String kq = xor(xor(binToHex(hextoBin(w)+"000"), binToHex(hextoBin(w)+"00")),binToHex(hextoBin(w)+"0"));
//        unsigned int kq = (w << 3) ^ (w << 2) ^ (w << 1);
        if(Integer.parseInt(hextoBin(kq), 2) > (size*4)) kq = xor(kq,"46C"); // 0x11b<<2 = 46c
        if(Integer.parseInt(hextoBin(kq), 2) > (size*2)) kq = xor(kq,"236"); // 0x11b<<1 = 236
        if(Integer.parseInt(hextoBin(kq), 2) > size) kq = xor(kq,"11B");
        kq = kq.substring(kq.length()-2);
        return kq;
    }


}
