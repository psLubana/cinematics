package com.cinematics.web.rest.errors;

public class MovieAlreadyExistsException extends BadRequestAlertException {

    public MovieAlreadyExistsException() {
        super(ErrorConstants.LOGIN_ALREADY_USED_TYPE, "Login already in use", "userManagement", "userexists");
    }
}
