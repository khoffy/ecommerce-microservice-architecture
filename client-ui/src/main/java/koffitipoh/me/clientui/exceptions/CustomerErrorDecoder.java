package koffitipoh.me.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoker, Response response) {
        if(response.status() == 400) {
            return new ProductBadRequestException("Requete Incorrecte");
        }
        return defaultErrorDecoder.decode(invoker, response);
    }
    
}
