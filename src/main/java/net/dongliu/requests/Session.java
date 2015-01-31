package net.dongliu.requests;

import net.dongliu.requests.exception.RuntimeURISyntaxException;
import net.dongliu.requests.struct.Method;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;

/**
 * one http session, share cookies, basic auth across http request.
 *
 * @author Dong Liu dongliu@wandoujia.com
 */
public class Session {
    private final HttpClientContext context;

    Session() {
        context = HttpClientContext.create();
        BasicCookieStore cookieStore = new BasicCookieStore();
        context.setCookieStore(cookieStore);
    }

    HttpClientContext getContext() {
        return context;
    }

    /**
     * get method
     */
    public RequestBuilder get(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.GET);
    }

    /**
     * head method
     */
    public RequestBuilder head(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.HEAD);
    }

    /**
     * get url, and return content
     */
    public RequestBuilder post(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.POST);
    }

    /**
     * put method
     */
    public RequestBuilder put(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.PUT);
    }

    /**
     * delete method
     */
    public RequestBuilder delete(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.DELETE);
    }

    /**
     * options method
     */
    public RequestBuilder options(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.OPTIONS);
    }

    /**
     * patch method
     */
    public RequestBuilder patch(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.PATCH);
    }

    /**
     * trace method
     */
    public RequestBuilder trace(String url) throws RuntimeURISyntaxException {
        return newBuilder(url).method(Method.TRACE);
    }
//
//    /**
//     * connect
//     */
//    public static RequestBuilder connect(String url) throws InvalidUrlException {
//        return newBuilder(url).method(Method.CONNECT);
//    }

    /**
     * create request builder with url
     */
    private RequestBuilder newBuilder(String url) throws RuntimeURISyntaxException {
        return new RequestBuilder().session(this).url(url);
    }
}
