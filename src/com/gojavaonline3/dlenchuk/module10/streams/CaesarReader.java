package com.gojavaonline3.dlenchuk.module10.streams;


import com.gojavaonline3.dlenchuk.module09.cipher.Caesar;
import com.gojavaonline3.dlenchuk.module09.cipher.CaesarDecoder;

import java.io.IOException;
import java.io.Reader;

/**
 * Decodes encoded a char stream
 *
 * @see java.io.Reader
 * @see Caesar
 * @see CaesarDecoder
 * @see CaesarWriter
 *
 * @author Dmitrij Lenchuk
 * @since 24.06.2016
 */
class CaesarReader extends Reader {

    /**The cipher object. The object implements the Caesar decryption */
    private Caesar caesar;

    /**Input stream */
    private Reader in;

    /**
     * Creates a decoding character-input stream that uses an Caesar algorithm of
     * the specified shift.
     *
     * @param  in       A Reader
     * @param  shift    A Caesar Algorithm Shift
     */
    CaesarReader(Reader in, int shift) {
        this.in = in;
        this.caesar = new Caesar(shift);
    }

    /**
     * Reads characters into a portion of an array.
     *
     * <p> This method implements the general contract of the corresponding
     * <code>{@link Reader#read(char[], int, int) read}</code> method of the
     * <code>{@link Reader}</code> class.  As an additional convenience, it
     * decodes chars by the Caesar algorithm. This iterated
     * <code>read</code> continues until one of the following conditions becomes
     * true: <ul>
     *
     *   <li> The specified number of characters have been read,
     *
     *   <li> The <code>read</code> method of the underlying stream returns
     *   <code>-1</code>, indicating end-of-file, or
     *
     *   <li> The <code>ready</code> method of the underlying stream
     *   returns <code>false</code>, indicating that further input requests
     *   would block.
     *
     * </ul> If the first <code>read</code> on the underlying stream returns
     * <code>-1</code> to indicate end-of-file then this method returns
     * <code>-1</code>.  Otherwise this method returns the number of characters
     * actually read.
     *
     * @param      cbuf  Destination buffer
     * @param      off   Offset at which to start storing characters
     * @param      len   Maximum number of characters to read
     *
     * @return     The number of characters read, or -1 if the end of the
     *             stream has been reached
     *
     * @exception  IOException  If an I/O error occurs
     */
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            int countChar = in.read(cbuf, off, len);
            caesar.execute(CaesarDecoder::transform, cbuf);
            return countChar;
        }
    }

    /** Checks to make sure that the stream has not been closed */
    private void ensureOpen() throws IOException {
        if (in == null)
            throw new IOException("Stream closed");
    }

    /**Closes a stream*/
    public void close() throws IOException {
        synchronized (lock) {
            if (in == null)
                return;
            try {
                in.close();
            } finally {
                in = null;
            }
        }
    }

}
