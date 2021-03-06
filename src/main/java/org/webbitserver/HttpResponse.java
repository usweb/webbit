package org.webbitserver;

import java.nio.charset.Charset;

public interface HttpResponse {
    HttpResponse charset(Charset charset);

    Charset charset();

    HttpResponse status(int status);

    int status();

    HttpResponse header(String name, String value);

    HttpResponse header(String name, int value);

    HttpResponse content(String content);

    HttpResponse content(byte[] content);

    HttpResponse error(Throwable error);

    HttpResponse end();

}
