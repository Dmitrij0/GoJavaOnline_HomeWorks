package com.gojavaonline3.dlenchuk.module09.cipher;


/**Functional interface
 *
 * @author Dmitrij Lenchyk
 * @since 22.06.2016
 * */
interface Cipher {

    /**Char transformation
     *
     * @param ch    The char to be processed
     * @param shift The shift of the algorithm
     * @param norma The norma of a group of chars
     * @param power The power of an alphabet
     * */
    char transform(char ch, int shift, int norma, int power);

}
