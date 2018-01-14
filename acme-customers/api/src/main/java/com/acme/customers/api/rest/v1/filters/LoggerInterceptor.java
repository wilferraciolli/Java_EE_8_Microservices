package com.acme.customers.api.rest.v1.filters;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.*;
import java.util.logging.Logger;

/**
 * The type Logger interceptor. Interceptor to log every request and response.
 */
@Provider
public class LoggerInterceptor implements WriterInterceptor, ReaderInterceptor {

    private static final Logger logger = Logger.getLogger(LoggerInterceptor.class.getName());

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {

        InputStream inputStream = context.getInputStream();

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        String requestContent = new String(bytes);

        logger.info("Request: " + requestContent);

        context.setInputStream(new ByteArrayInputStream(requestContent.getBytes()));

        return context.proceed();
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {

        OutputStream originalStream = context.getOutputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        context.setOutputStream(baos);

        try {

            context.proceed();
        } finally {

            logger.info("Response: " + baos.toString("UTF-8"));

            baos.writeTo(originalStream);
            baos.close();

            context.setOutputStream(originalStream);
        }
    }
}
