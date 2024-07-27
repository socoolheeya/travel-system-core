package com.socoolheeya.travel.system.core.model.exception;

import com.socoolheeya.travel.system.core.enums.CommonSupplierEnums;
import com.socoolheeya.travel.system.core.enums.ErrorEnums;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TravelBlockingException extends BaseException {
    public TravelBlockingException() {
        super(ErrorEnums.TOO_MANY_REQUESTS.getMessage());
    }

    public TravelBlockingException(int code, String message) {
        super(code, HttpStatus.TOO_MANY_REQUESTS, message);
    }

    public TravelBlockingException(int code, HttpStatus status, String message) {
        super(code, status, message);
    }

    public TravelBlockingException(int code, HttpStatus status, String message, CommonSupplierEnums supplier) {
        super(code, status, message, supplier);
    }
}
