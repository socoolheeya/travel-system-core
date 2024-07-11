package com.socoolheeya.travel.system.core.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorEnums {
    /**
     * 10xx 시설 조회
     */
    NOT_FOUND_PROPERTY(1001, HttpStatus.BAD_REQUEST, "숙소를 찾을 수 없습니다"),
    NOT_FOUND_PROPERTY_IMAGES(1002, HttpStatus.BAD_REQUEST, "숙소 이미지를 찾을 수 없습니다"),


    /**
     * 11xx 시설 저장
     */
    NOT_FOUND_ADDRESS(1101, HttpStatus.BAD_REQUEST, "주소의 검색 결과가 없습니다"),
    FAILED_SYNC_PROPERTY(1102, HttpStatus.INTERNAL_SERVER_ERROR, "숙소 동기화 실패하였습니다"),
    FAILED_SAVING_PROPERTY(1103, HttpStatus.INTERNAL_SERVER_ERROR, "숙소 저장 실패하였습니다"),

    /**
     *  20xx 객실 조회
     */
    NOT_FOUND_ROOM(2001, HttpStatus.BAD_REQUEST, "객실을 찾을 수 없습니다"),

    /**
     *  21xx 객실 저장
     */
    FAILED_SAVING_ROOM(2101, HttpStatus.BAD_REQUEST, "객실 저장 실패하였습니다"),

    /**
     *  30xx 요금제 조회
     */
    NOT_FOUND_RATE_PLAN(3001, HttpStatus.BAD_REQUEST, "요금제를 찾을 수 없습니다"),

    /**
     *  31xx 요금제 저장
     */
    FAILED_SAVING_RATE_PLAN(3101, HttpStatus.INTERNAL_SERVER_ERROR, "요금제 저장 오류"),

    /**
     *  40xx 요금 조회
     */
    NOT_FOUND_RATE(4001, HttpStatus.BAD_REQUEST, "요금을 찾을 수 없습니다"),

    /**
     * 50xx 예약 조회
     */
    INVALID_CHECKIN(5001, HttpStatus.BAD_REQUEST, "체크인 날짜가 오늘보다 커야 합니다"),
    INVALID_STAYS(5002, HttpStatus.BAD_REQUEST, "박수 조건은 15일 보다 작아야 합니다"),
    INVALID_ADULTS(5003, HttpStatus.BAD_REQUEST, "성인은 최소 1명 이상이어야 합니다"),
    NOT_FOUND_AVAILABILITY(5003, HttpStatus.BAD_REQUEST, "예약 조회 결과가 존재하지 않습니다"),


    /**
     * 51xx 예약 요청
     *
     */
    INVALID_RATE_PLAN(5101, HttpStatus.BAD_REQUEST, "요금제 정보가 변경되었습니다"),
    NOT_ALLOWED_CHILDREN(5102, HttpStatus.BAD_REQUEST, "어린이는 허용할 수 없습니다"),
    NOT_ENOUGH_BLOCK(5103, HttpStatus.BAD_REQUEST, "블럭이 부족합니다"),
    FAILED_CMS_BOOKING(5104, HttpStatus.INTERNAL_SERVER_ERROR, "CMS 예약이 실패하였습니다"),


    /**
     * 52xx 예약 취소
     */
    NOT_FOUND_CANCEL_POLICY(5201, HttpStatus.BAD_REQUEST, "취소 규정을 찾을 수 없습니다"),
    NOT_FOUND_BLOCK(5202, HttpStatus.BAD_REQUEST, "블럭을 찾을 수 없습니다"),

    /**
     * 59xx CMS 공통
     */
    FAILED_CMS_CONNECTION(5901, HttpStatus.INTERNAL_SERVER_ERROR, "CMS와 통신할 수 없습니다"),

    /**
     * 80xx 권한
     */
    WRONG_KEY(8001, HttpStatus.UNAUTHORIZED, "만료되었거나 존재하지 않는 키입니다."),
    NO_AUTHORITY(8002, HttpStatus.UNAUTHORIZED, "권한이 없습니다"),
    INVALID_ACCESS_TOKEN(8003, HttpStatus.UNAUTHORIZED, "권한이 없습니다"),

    /**
     * 4xx 공통 서버 에러
     */
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),
    REQUEST_TIMEOUT(408, HttpStatus.REQUEST_TIMEOUT, "요청 시간이 초과하였습니다"),
    PAYLOAD_TOO_LARGE(413, HttpStatus.PAYLOAD_TOO_LARGE, "페이로드가 너무 큽니다"),

    /**
     * 5xx 공통 서버 에러
     */
    SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "처리 중 에러가 발생하였습니다"),
    FAILED_DECRYPT(500, HttpStatus.INTERNAL_SERVER_ERROR, "복호화 실패하였습니다");


    private final Integer code;
    private final HttpStatus status;
    private final String message;

    ErrorEnums(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
