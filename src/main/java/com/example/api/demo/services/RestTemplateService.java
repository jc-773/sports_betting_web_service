package com.example.api.demo.services;

import java.util.Hashtable;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class RestTemplateService implements IRestTemplateService {
    
    @Autowired
    private RestTemplate restTemplate;

    public RestTemplateService() {
       
    }

    @Override
    public <T, R> T getForObjectResponse(Class<T> clazz, String url, Hashtable<String, String> customHeaders) {
        try {
            System.out.println("Get request made to " + url);
            HttpHeaders headers = createHttpHeaders(customHeaders);
            HttpEntity httpEntity = new HttpEntity(headers);
            ObjectMapper objectMapper = new ObjectMapper();
            
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<T>() {
                    });

                   
            response.hasBody();
            return response.getBody();
        } catch (Exception e) {
           // LOGGER.info(e.getMessage());
        }
        return null;
    }

    private HttpHeaders createHttpHeaders(Hashtable<String, String> customeHeaders) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        if (customeHeaders != null) {
            Set<String> headerKeys = customeHeaders.keySet();
            for (String headerKey : headerKeys) {
                headers.add(headerKey, customeHeaders.get(headerKey));
            }
        }
        return headers;
    }

}
