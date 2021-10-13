package com.phillips.sportsanalytics.helper;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class URIHelper {
    public static URI createURI(String host, String[] params, String[] args){

        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(host);

        for(int i = 0; i < params.length; i++){
            if(args[i] != null && !args[i].isEmpty()){
                builder = builder.queryParam(params[i], args[i]);
            }
        }

        return builder.build().toUri();
    }

    public static URI createURI(String host){

        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(host);

        return builder.build().toUri();
    }
}
