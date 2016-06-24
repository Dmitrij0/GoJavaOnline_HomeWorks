package com.gojavaonline3.dlenchuk.module10.streams;

import com.gojavaonline3.dlenchuk.module09.cipher.Caesar;
import com.gojavaonline3.dlenchuk.module09.cipher.CaesarEncoder;

import java.io.IOException;
import java.io.Writer;

class CaesarWriter extends Writer {

    private Caesar caesar;
    private Writer out;


    CaesarWriter(Writer out, int shift) {
        this.out = out;
        this.caesar = new Caesar(shift);
    }

    public CaesarWriter(Object lock, Writer out, int shift) {
        super(lock);
        this.out = out;
        this.caesar = new Caesar(shift);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        synchronized (lock) {
            ensureOpen();
            cbuf = caesar.execute(CaesarEncoder::transform, cbuf);
            out.write(cbuf, off, len);
        }
    }

    private void ensureOpen() throws IOException {
        if (out == null)
            throw new IOException("Stream closed");
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
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
