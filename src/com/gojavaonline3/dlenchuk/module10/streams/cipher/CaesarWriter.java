package com.gojavaonline3.dlenchuk.module10.streams.cipher;

import com.gojavaonline3.dlenchuk.module09.cipher.Caesar;
import com.gojavaonline3.dlenchuk.module09.cipher.CaesarEncoder;

import java.io.IOException;
import java.io.Writer;

/**
 * Decodes encoded a char stream
 *
 * @see java.io.Writer
 * @see Caesar
 * @see CaesarEncoder
 * @see CaesarReader
 *
 * @author Dmitrij Lenchuk
 * @since 24.06.2016
 */
class CaesarWriter extends Writer {

    /**The cipher object. The object implements the Caesar encryption */
    private Caesar caesar;

    /**Output stream */
    private Writer out;

    /**
     * Creates a encoding character-output stream that uses an Caesar algorithm of
     * the specified shift.
     *
     * @param  out      A Writer
     * @param  shift    A Caesar Algorithm Shift
     */
    CaesarWriter(Writer out, int shift) {
        this.out = out;
        this.caesar = new Caesar(shift);
    }

    /**
     * Writes a portion of an encrypted array of characters.
     *
     * <p> Ordinarily this method stores characters from the given array into
     * this stream's buffer.
     *
     * @param  cbuf  A character array
     * @param  off   Offset from which to start reading characters
     * @param  len   Number of characters to write
     *
     * @exception  IOException  If an I/O error occurs
     */
    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            cbuf = caesar.execute(CaesarEncoder::transform, cbuf);
            out.write(cbuf, off, len);
        }
    }

    /** Checks to make sure that the stream has not been closed */
    private void ensureOpen() throws IOException {
        if (out == null)
            throw new IOException("Stream closed");
    }

    /**The class hasn't a buffer*/
    public void flush() throws IOException {
    }

    /**Closes a stream*/
    public void close() throws IOException {
        synchronized (lock) {
            if (out == null)
                return;
            try (Writer w = out) {
                flush();
            } finally {
                out = null;
            }
        }
    }
}
