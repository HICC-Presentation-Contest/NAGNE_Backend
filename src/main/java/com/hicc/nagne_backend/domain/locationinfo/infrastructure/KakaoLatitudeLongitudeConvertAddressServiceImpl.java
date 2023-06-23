package com.hicc.nagne_backend.domain.locationinfo.infrastructure;

import com.hicc.nagne_backend.common.annotation.DomainService;
import com.hicc.nagne_backend.common.exception.BusinessException;
import com.hicc.nagne_backend.common.exception.Error;
import com.hicc.nagne_backend.domain.locationinfo.domain.service.LatitudeLongitudeConvertAddressService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
public class KakaoLatitudeLongitudeConvertAddressServiceImpl implements LatitudeLongitudeConvertAddressService {

    @Value("${kakao.rest-api-key}")
    private String kakaoRestApiKey;

    private final RestTemplate restTemplate;

    @Override
    public String convertLatitudeLongitudeToAddress(String longitude, String latitude) {
        final HttpEntity<String> entity = getKakaoMapApiRequestHttpEntity();
        final String encodeLongitude = getEncode(longitude);
        final String encodeLatitude = getEncode(latitude);
        final String url = getKakaoMapApiUrl(encodeLongitude, encodeLatitude);
        final URI uri = getUri(url);
        System.out.println(uri);
        final ResponseEntity<String> simpleResponse = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        final JSONArray documents = getJsonArray(simpleResponse);
        final KakaoMapResponse kakaoMapResponse = parseKakaoMapResponse(documents);
        return kakaoMapResponse.getAddressName();
    }

    private static KakaoMapResponse parseKakaoMapResponse(JSONArray documents) {

        final KakaoMapResponse kakaoMapResponse;
        if (documents.isEmpty()) {
            kakaoMapResponse = new KakaoMapResponse("null");
        } else {
            JSONObject jsonObject = (JSONObject) documents.get(0);
            String addressName = (String) jsonObject.get("region_2depth_name");
            kakaoMapResponse = new KakaoMapResponse(addressName);
        }
        return kakaoMapResponse;
    }

    private static JSONArray getJsonArray(ResponseEntity<String> simpleResponse) {
        JSONParser jsonParser = new JSONParser();
        JSONObject parse = null;
        try {
            parse = (JSONObject) jsonParser.parse(simpleResponse.getBody());
        } catch (Exception e) {
            throw new BusinessException(Error.KAKAO_MAP_ERROR);
        }
        JSONArray documents = (JSONArray) parse.get("documents");
        return documents;
    }

    private HttpEntity<String> getKakaoMapApiRequestHttpEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String key = kakaoRestApiKey;
        httpHeaders.set("Authorization", "KakaoAK " + key);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return entity;
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

    private String getKakaoMapApiUrl(String encodeLongitude, String encodeLatitude) {
        return "https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x="
                + encodeLongitude +"&y=" + encodeLatitude+ "&size=1";
    }

    private static String getEncode(String s) {
        String encode;
        try {
            encode = URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new BusinessException(Error.KAKAO_MAP_ERROR);
        }
        return encode;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    private static class KakaoMapResponse {
        private String addressName;
        public KakaoMapResponse(String address_name) {
            this.addressName = address_name;
        }
    }
}
