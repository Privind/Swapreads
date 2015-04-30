package com.japa.backend.endpoints;

import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.japa.backend.beans.GrResponseBean;

import java.io.StringReader;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 * An endpoint class we are exposing
 *
 google-api-client-1.20.0.jar
 google-api-client-appengine-1.20.0.jar
 google-api-client-servlet-1.20.0.jar
 google-oauth-client-1.20.0.jar
 google-oauth-client-appengine-1.20.0.jar
 google-oauth-client-servlet-1.20.0.jar
 google-http-client-1.20.0.jar
 google-http-client-appengine-1.20.0.jar
 gson-2.1.jar
 jackson-core-asl-1.9.11.jar
 jackson-core-2.1.3.jar
 jdo2-api-2.3-eb.jar
 jsr305-1.3.9.jar
 protobuf-java-2.4.1.jar
 transaction-api-1.1.jar
 xpp3-1.1.4c.jar

 */
@Api(
        name = "dataAccessApi",
        version = "v1",
        resource = "dataBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.japa.com",
                ownerName = "backend.japa.com",
                packagePath = ""
        )
)
public class GRDataAccessEndpoint {

    private static final Logger logger = Logger.getLogger(GRDataAccessEndpoint.class.getName());
    private static final String CONSUMER_KEY = "ViMuRLOzg6OshTaP5xCV4w";
    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    /**
     * This method gets the <code>DataBean</code> object associated with the specified <code>id</code>.
     *
     *
     * @return The <code>DataBean</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getBookData")
    public GrResponseBean getBookData() throws Throwable{
    //public DataBean getBookData(@Named("id") Long id) throws Throwable{
        // TODO: Implement this function
        logger.info("Calling getBookData method");
        GrResponseBean response = new GrResponseBean();
/*
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        while (currentLine.equalsIgnoreCase("n")) {
            System.out.println("Have you authorized me? (y/n)");
            currentLine = in.readLine();
        }

        // Step 3: Once the consumer has redirected the user back to the oauth_callback
        // URL you can request the access token the user has approved. You use the
        // request token to sign this request. After this is done you throw away the
        // request token and use the access token returned. You should store this
        // access token somewhere safe, like a database, for future use.
        OAuthGetAccessToken accessToken = new OAuthGetAccessToken(
                ACCESS_TOKEN_URL);
        accessToken.consumerKey = CONSUMER_KEY;
        accessToken.signer = signer;
        accessToken.transport = TRANSPORT;
        accessToken.temporaryToken = requestTokenResponse.token;

        OAuthCredentialsResponse accessTokenResponse = accessToken.execute();
        System.out.println("Access Token:");
        System.out.println("    - oauth_token        = " + accessTokenResponse.token);
        System.out.println("    - oauth_token_secret = " + accessTokenResponse.tokenSecret);
        System.out.println("\nYou may now access protected resources using the access tokens above.");

        // updates signer's token shared secret
        signer.tokenSharedSecret = accessTokenResponse.tokenSecret;
*/
        //com.google.api.client.extensions.appengine.http.UrlFetchTransport
        //OAuthParameters parameters = new OAuthParameters();
        //parameters.consumerKey = CONSUMER_KEY;
        //parameters.token = accessTokenResponse.token;
        //parameters.signer = signer;

        // utilize accessToken to access protected resources
        UrlFetchTransport HTTP_TRANSPORT = new UrlFetchTransport();
        HttpRequestFactory httprequestFactory = HTTP_TRANSPORT.createRequestFactory();
        GenericUrl url = new GenericUrl("https://www.goodreads.com/search.xml?key="+CONSUMER_KEY+"&q=Ender%27s+Game");
        HttpRequest request = httprequestFactory.buildGetRequest(url);
        HttpResponse resp = request.execute();
        StringBuffer buffer = new StringBuffer();

        if(resp.getStatusCode() == 200){
            buffer.append(resp.parseAsString());
            JAXBContext jaxbContext = JAXBContext.newInstance(GrResponseBean.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            response = (GrResponseBean) unmarshaller.unmarshal(new StreamSource( new StringReader( buffer.toString() ) ) );
        }

        System.out.println("Response body:" + response);

        //dataBean.setData(buffer.toString());

        return response;
    }

    /**
     * This inserts a new <code>DataBean</code> object.
     *
     * @param dataBean The object to be added.
     * @return The object to be added.
     */
    //@ApiMethod(name = "insertDataBean")
    //public SearchBean insertDataBean(SearchBean dataBean) {
        // TODO: Implement this function
    //    logger.info("Calling insertDataBean method");
    //    return dataBean;
    //}
}