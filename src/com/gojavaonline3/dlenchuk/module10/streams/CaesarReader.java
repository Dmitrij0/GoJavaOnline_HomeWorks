package com.gojavaonline3.dlenchuk.module10.streams;


import com.gojavaonline3.dlenchuk.module09.cipher.Caesar;
import com.gojavaonline3.dlenchuk.module09.cipher.CaesarDecoder;

import java.io.IOException;
import java.io.Reader;

class CaesarReader extends Reader {

    private Caesar caesar;
    private Reader in;

    CaesarReader(Reader in, int shift) {
        this.in = in;
        this.caesar = new Caesar(shift);
    }

    CaesarReader(Object lock, Reader in, int shift) {
        super(lock);
        this.in = in;
        this.caesar = new Caesar(shift);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            int countChar = in.read(cbuf, off, len);
            caesar.execute(CaesarDecoder::transform, cbuf);
            return countChar;
        }
    }

    private void ensureOpen() throws IOException {
        if (in == null)
            throw new IOException("Stream closed");
    }

    @Override
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
