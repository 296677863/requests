package net.dongliu.requests;

import net.dongliu.requests.struct.Headers;
import org.apache.http.HttpEntity;

import java.io.IOException;

/**
 * interface to trans data to result
 *
 * @author Dong Liu
 */
interface ResponseProcessor<T> {

    static ResponseProcessor<String> string = new StringResponseProcessor(null);

    static ResponseProcessor<byte[]> bytes = new BytesResponseProcessor();

    /**
     * from http Body to result with type T
     *
     * @param httpEntity may be null if no http entity is set
     */
    T convert(int statusCode, Headers headers, HttpEntity httpEntity) throws IOException;
}
