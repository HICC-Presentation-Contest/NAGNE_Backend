package com.hicc.nagne_backend.domain.locationinfo.infrastructure;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.common.config.RestTemplateConfig;
import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;
import com.hicc.nagne_backend.domain.locationinfo.domain.entity.Address;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.AddressConvertLatitudeLongitudeService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Slf4j
@DomainService
@RequiredArgsConstructor
public class KakaoAddressConvertLatitudeLongitudeServiceImpl implements AddressConvertLatitudeLongitudeService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kakao.rest-api-key}")
    private String kakaoRestApiKey;

    public Address convertAddressToLatitudeLongitude(String tripAddress, String placeName) {
        final String city = getFullAddress(tripAddress, placeName);
        final HttpEntity<String> entity = getKakaoMapApiRequestHttpEntity();
        final String encode = encodingFullAddress(city);
        final String url = getKakaoMapApiUrl(encode);
        final URI uri = getUri(url);
        final ResponseEntity<String> kakaoMapApiResponse = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        final JSONArray documents = getJsonArray(kakaoMapApiResponse);
        final KakaoMapResponse kakaoMapResponse = parseKakaoMapResponse(documents);
        return Address.builder()
                .placeName(placeName)
                .latitude(kakaoMapResponse.getY())
                .longitude(kakaoMapResponse.getX())
                .build();
    }

    private static String getKakaoMapApiUrl(String encode) {
        final String url = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" + encode +"&size=1";
        return url;
    }

    private static KakaoMapResponse parseKakaoMapResponse(JSONArray documents) {
        final KakaoMapResponse kakaoMapResponse;
        if(documents.isEmpty()){

            kakaoMapResponse = new KakaoMapResponse("0", "0", "0");
        }else{
            JSONObject jsonObject = (JSONObject) documents.get(0);
            String x = (String) jsonObject.get("x");
            String y = (String) jsonObject.get("y");
            String place_name = (String) jsonObject.get("place_name");
            kakaoMapResponse = new KakaoMapResponse(place_name, x, y);
        }
        return kakaoMapResponse;
    }

    private static JSONArray getJsonArray(ResponseEntity<String> simpleResponse) {
        JSONParser jsonParser = new JSONParser();
        JSONObject parse;
        try {
            parse = (JSONObject) jsonParser.parse(simpleResponse.getBody());
        } catch (ParseException e) {
            e.getStackTrace();
            throw new BusinessException(Error.KAKAO_MAP_ERROR);
        }
        JSONArray documents = (JSONArray) parse.get("documents");
        return documents;
    }

    private static URI getUri(String url) {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new BusinessException(Error.KAKAO_MAP_ERROR);
        }
        return uri;
    }

    private static String encodingFullAddress(String fullAddress) {
        final String encode;
        try {
            encode = URLEncoder.encode(fullAddress, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(Error.KAKAO_MAP_ERROR);
        }
        return encode;
    }

    private static String getFullAddress(String tripAddress, String LocationAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(tripAddress).append(" ").append(LocationAddress);
        String city = stringBuilder.toString();
        return city;
    }

    private HttpEntity<String> getKakaoMapApiRequestHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String key = kakaoRestApiKey;
        httpHeaders.set("Authorization", "KakaoAK " + key);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return entity;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    private static class KakaoMapResponse {
        private String place_name;
        private String x;
        private String y;

        public KakaoMapResponse(String place_name, String x, String y) {
            this.place_name = place_name;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "KakaoMapResponse{" +
                    "place_name='" + place_name + '\'' +
                    ", x='" + x + '\'' +
                    ", y='" + y + '\'' +
                    '}';
        }
    }
}
