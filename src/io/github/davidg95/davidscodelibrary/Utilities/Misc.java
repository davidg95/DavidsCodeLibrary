/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Utilities;

import java.util.Random;

/**
 * Class which contains misc static methods.
 *
 * @author David
 */
public abstract class Misc {

    /**
     * Method to generate a valid public IPv4 address.
     *
     * This method will note generate any IPv4 address that are reserved for use
     * in private networks, loopback addresses, multicasting, link-local or any
     * other reason that an IP should not be used publicaly. Consult
     * https://en.wikipedia.org/wiki/Reserved_IP_addresses for the list these
     * IPv4 addresses were taken from.
     *
     * @return valid public IP address as a String.
     */
    public static String generateUsablePublicIPv4() {
        boolean valid = false;
        int octet1 = 0;
        int octet2 = 0;
        int octet3 = 0;
        int octet4 = 0;

        while (!valid) {
            octet1 = (int) (Math.random() * 255);
            octet2 = (int) (Math.random() * 255);
            octet3 = (int) (Math.random() * 255);
            octet4 = (int) (Math.random() * 255);

            //Check that the IP is a valid usable public IP address.
            //From https://en.wikipedia.org/wiki/Reserved_IP_addresses.
            valid = !(octet1 == 0
                    || //0.0.0.0 - 0.255.255.255
                    octet1 == 10
                    || //10.0.0.0 - 10.255.255.255
                    (octet1 == 10 && octet2 > 64 && octet2 < 127)
                    || //10.64.0.0 - 10.127.255.255
                    octet1 == 127
                    || //127.0.0.0 - 127.255.255.255
                    (octet1 == 169 && octet2 == 254)
                    || //169.254.0.0 - 169.254.255.255
                    (octet1 == 172 && octet2 >= 16 && octet2 <= 31)
                    || //172.16.0.0 - 172.32.255.255
                    (octet1 == 192 && octet2 == 0 && octet3 == 0)
                    || //192.0.0.0 - 192.0.0.255
                    (octet1 == 192 && octet2 == 0 && octet3 == 2)
                    || //192.0.2.0 - 192.0.2.255
                    (octet1 == 192 && octet2 == 88 && octet3 == 99)
                    || //192.88.99.0 - 192.88.99.255
                    (octet1 == 192 && octet2 == 168)
                    || //192.168.0.0 - 192.168.255.255
                    (octet1 == 198 && (octet2 == 18 || octet2 == 19))
                    || //198.18.0.0 - 198.19.255.255
                    (octet1 == 198 && octet2 == 51 && octet3 == 100)
                    || //198.51.100.0 - 198.51.100.255
                    (octet1 == 203 && octet2 == 0 && octet3 == 113)
                    || //203.0.113.0 - 203.0.113.255
                    octet1 >= 224); //224.0.0.0 - 255.255.255.255
        }

        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }

    public static String generateUsablePublicIPv6() {
        boolean valid = false;
        String[] blocks = new String[8];
        
        for (int i = 0; i < 8; i++) {
            blocks[i] = generateRandomHexString();
        }
        
        String result = "";
        
        for(String s: blocks){
            result += ":" + s;
        }
        
        return result.substring(1);
    }

    /**
     * Method which generate a String of 4 random hex digits.
     *
     * @return a String of 4 random hex digits.
     */
    private static String generateRandomHexString() {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < 4) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, 4);
    }
}
