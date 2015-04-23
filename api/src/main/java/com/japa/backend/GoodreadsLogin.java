/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.japa.backend;

import com.google.api.client.auth.oauth.OAuthAuthorizeTemporaryTokenUrl;
import com.google.api.client.auth.oauth.OAuthCredentialsResponse;
import com.google.api.client.auth.oauth.OAuthGetTemporaryToken;
import com.google.api.client.auth.oauth.OAuthHmacSigner;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "login", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.japa.com", ownerName = "backend.japa.com", packagePath = ""))
public class GoodreadsLogin {

    //May have to change it to com.google.api.client.extensions.appengine.http.UrlFetchTransport for app engine
    private static final UrlFetchTransport TRANSPORT = new UrlFetchTransport();

    //private static final String APP_ID = "your_app_id_here";
    private static final String CONSUMER_KEY = "ViMuRLOzg6OshTaP5xCV4w";
    private static final String CONSUMER_SECRET = "krRKYF3chTzVsvn9aBT5EJNf0XT0ckDhV8vhy9lE";

    //private static final String PROTECTED_SERVICE_URL = "https://" + APP_ID + ".appspot.com/resource";
    private static final String REQUEST_TOKEN_URL = "http://www.goodreads.com/oauth/request_token";
    private static final String AUTHORIZE_URL = "http://www.goodreads.com/oauth/authorize?mobile=1";
    //private static final String ACCESS_TOKEN_URL = "http://www.goodreads.com/oauth/access_token";

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getAuthUrl")
    public AuthBean getAuthUrl() throws Throwable {
        AuthBean response = new AuthBean();
        // this signer will be used to sign all the requests in the "oauth dance"
        OAuthHmacSigner signer = new OAuthHmacSigner();
        signer.clientSharedSecret = CONSUMER_SECRET;

        // Step 1: Get a request token. This is a temporary token that is used for
        // having the user authorize an access token and to sign the request to obtain
        // said access token.
        OAuthGetTemporaryToken requestToken = new OAuthGetTemporaryToken(REQUEST_TOKEN_URL);
        requestToken.consumerKey = CONSUMER_KEY;
        requestToken.transport = TRANSPORT;
        requestToken.signer = signer;

        OAuthCredentialsResponse requestTokenResponse = requestToken.execute();

        System.out.println("Request Token:");
        System.out.println("    - oauth_token        = " + requestTokenResponse.token);
        System.out.println("    - oauth_token_secret = " + requestTokenResponse.tokenSecret);

        // updates signer's token shared secret
        signer.tokenSharedSecret = requestTokenResponse.tokenSecret;

        OAuthAuthorizeTemporaryTokenUrl authorizeUrl = new OAuthAuthorizeTemporaryTokenUrl(AUTHORIZE_URL);
        authorizeUrl.temporaryToken = requestTokenResponse.token;

        // After the user has granted access to you, the consumer, the provider will
        // redirect you to whatever URL you have told them to redirect to. You can
        // usually define this in the oauth_callback argument as well.
        response.setAuthUrl(authorizeUrl.build());
        System.out.println("Go to the following link in your browser:\n"
                + authorizeUrl.build());
        return response;
    }

}
